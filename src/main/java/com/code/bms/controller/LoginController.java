package com.code.bms.controller;

import com.code.bms.service.BookService;
import com.code.bms.service.LoginService;
import com.code.bms.pojo.Admin;
import com.code.bms.pojo.BookInfo;
import com.code.bms.pojo.ReaderCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private BookService bookService;

    /**
     * 登录页面
     * @param request request
     * @return String
     */
    @RequestMapping(value = {"/", "/login.action"})
    public String toLogin(HttpServletRequest request) {
        request.getSession().invalidate();
        return "login";
    }

    /**
     * 退出登录
     * @param request request
     * @return String
     */
    @RequestMapping("/logout.action")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login.action";
    }

    /**
     * 负责处理loginCheck.html请求
     * 请求参数会根据参数名称默认契约自动绑定到相应方法的入参中
     * @param request request
     * @return Object
     */
    @RequestMapping(value = "loginCheck.action", method = RequestMethod.POST)
    public @ResponseBody
    Object loginCheck(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String passwd = request.getParameter("passwd");
        boolean isReader = this.loginService.hasMatchReader(id, passwd);
        boolean isAdmin = this.loginService.hasMatchAdmin(id, passwd);
        HashMap<String, String> res = new HashMap<>();
        if (!isAdmin && !isReader) {
            res.put("stateCode", "0");
            res.put("msg", "账号或密码错误！");
            return res;
        }
        if (isAdmin) {
            Admin admin = new Admin();
            admin.setAdminId(id);
            admin.setPassword(passwd);
            request.getSession().setAttribute("admin", admin);
            res.put("stateCode", "1");
            res.put("msg", "管理员登陆成功！");
            return res;
        } else {
            ReaderCard readerCard = loginService.findReaderCardByUserId(id);
            request.getSession().setAttribute("readercard", readerCard);
            res.put("stateCode", "2");
            res.put("msg", "读者登陆成功！");
            return res;
        }
    }

    @RequestMapping("/admin_main.action")
    public String toAdminMain(Model model) {
        List<BookInfo> books = this.bookService.bookRank();
        model.addAttribute("books", books);
        return "admin_main";
    }

    @RequestMapping("/reader_main.action")
    public String toReaderMain(Model model) {
        List<BookInfo> books = this.bookService.bookRank();
        model.addAttribute("books", books);
        return "reader_main";
    }

    @RequestMapping("/admin_repasswd.action")
    public String reAdminPasswd() {
        return "admin_repasswd";
    }

    @RequestMapping("/admin_repasswd_do.action")
    public String reAdminPasswdDo(HttpServletRequest request, String oldPasswd, String newPasswd, RedirectAttributes redirectAttributes) {

        Admin admin = (Admin) request.getSession().getAttribute("admin");
        int id = admin.getAdminId();
        String passwd = loginService.getAdminPasswd(id);

        if (passwd.equals(oldPasswd)) {
            boolean succ = loginService.adminRePasswd(id, newPasswd);
            if (succ) {

                redirectAttributes.addFlashAttribute("succ", "密码修改成功！");
                return "redirect:/admin_repasswd.action";
            } else {
                redirectAttributes.addFlashAttribute("error", "密码修改失败！");
                return "redirect:/admin_repasswd.action";
            }
        } else {
            redirectAttributes.addFlashAttribute("error", "旧密码错误！");
            return "redirect:/admin_repasswd.action";
        }
    }

    //配置404页面
    @RequestMapping("*")
    public String notFond() {
        return "404";
    }
}
