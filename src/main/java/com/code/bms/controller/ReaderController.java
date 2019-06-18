package com.code.bms.controller;

import com.code.bms.service.LoginService;
import com.code.bms.service.ReaderCardService;
import com.code.bms.service.ReaderInfoService;
import com.code.bms.pojo.PageResult;
import com.code.bms.pojo.ReaderCard;
import com.code.bms.pojo.ReaderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class ReaderController {
    @Autowired
    private ReaderInfoService readerInfoService;

    @Autowired
    private ReaderCardService readerCardService;

    @Autowired
    private LoginService loginService;

    @RequestMapping("allreaders.action")
    public String allBooks(Model model,@RequestParam(defaultValue="1")Integer pageNum,
                           @RequestParam(defaultValue="5")Integer pageSize) {
        PageResult<ReaderInfo> readers = this.readerInfoService.readerInfos(pageNum, pageSize);
        model.addAttribute("readers",readers.getList());

        model.addAttribute("page",readers);
        return "admin_readers";
    }

    @RequestMapping("reader_delete.action")
    public String readerDelete(Integer readerId, RedirectAttributes redirectAttributes) {
        boolean success = this.readerInfoService.deleteReaderInfo(readerId);

        if (success) {
            redirectAttributes.addFlashAttribute("succ", "删除成功！");
            return "redirect:/allreaders.action";
        } else {
            redirectAttributes.addFlashAttribute("error", "删除失败！");
            return "redirect:/allreaders.action";
        }
    }

    @RequestMapping("reader_edit.action")
    public String readerInfoEdit(Integer readerId, Model model) {
        ReaderInfo readerInfo = readerInfoService.getReaderInfo(readerId);
        model.addAttribute("readerInfo", readerInfo);
        return "admin_reader_edit";
    }

    @RequestMapping("reader_edit_do.action")
    public String readerInfoEditDo(ReaderInfo readerInfo, RedirectAttributes redirectAttributes) {
        boolean succ = this.readerInfoService.editReader(readerInfo);

        if (succ) {
            redirectAttributes.addFlashAttribute("succ", "读者修改成功！");
            return "redirect:/allreaders.action";
        } else {
            redirectAttributes.addFlashAttribute("error", "读者修改失败！");
            return "redirect:/allreaders.action";
        }
    }

    @RequestMapping("reader_add.action")
    public String readerInfoAdd() {
        return "admin_reader_add";
    }

    @RequestMapping("reader_add_do.action")
    public String readerInfoAddDo(ReaderInfo readerInfo, RedirectAttributes redirectAttributes) {
        boolean succ = this.readerInfoService.addReader(readerInfo);
        if (succ) {
            redirectAttributes.addFlashAttribute("succ", "读者添加成功！");
            return "redirect:/allreaders.action";
        } else {
            redirectAttributes.addFlashAttribute("succ", "读者添加失败！");
            return "redirect:/allreaders.action";
        }
    }

    @RequestMapping("/reader_info.action")
    public String toReaderInfo(HttpSession session, Model model) {
        ReaderCard readerCard = (ReaderCard) session.getAttribute("readercard");
        ReaderInfo readerInfo = this.readerInfoService.getReaderInfo(readerCard.getReaderId());
        model.addAttribute("readerinfo", readerInfo);
        return "reader_info";
    }

    @RequestMapping("reader_info_edit.action")
    public String readerInfoEditReader(HttpSession session, Model model) {
        ReaderCard readerCard = (ReaderCard) session.getAttribute("readercard");
        ReaderInfo readerInfo = this.readerInfoService.getReaderInfo(readerCard.getReaderId());
        model.addAttribute("readerinfo", readerInfo);
        return "reader_info_edit";

    }

    @RequestMapping("reader_edit_do_r.action")
    public String readerInfoEditDoReader(HttpSession session, ReaderInfo readerInfo, RedirectAttributes redirectAttributes) {
        ReaderCard readerCard = (ReaderCard) session.getAttribute("readercard");
        String name = readerInfo.getName();
        if (!readerCard.getName().equals(name)) {
            boolean succo = this.readerCardService.updateName(readerInfo.getReaderId(), name);

            boolean succ = this.readerInfoService.editReader(readerInfo);
            if (succ && succo) {
                ReaderCard readerCardNew = this.loginService.findReaderCardByUserId(readerCard.getReaderId());
                session.setAttribute("readercard", readerCardNew);
                redirectAttributes.addFlashAttribute("succ", "信息修改成功！");
                return "redirect:/reader_info.action";
            } else {
                redirectAttributes.addFlashAttribute("error", "信息修改失败！");
                return "redirect:/reader_info.action";
            }

        } else {
            boolean succ = this.readerInfoService.editReader(readerInfo);
            if (succ) {
                ReaderCard readerCardNew = this.loginService.findReaderCardByUserId(readerCard.getReaderId());
                session.setAttribute("readercard", readerCardNew);
                redirectAttributes.addFlashAttribute("succ", "信息修改成功！");
                return "redirect:/reader_info.action";
            } else {
                redirectAttributes.addFlashAttribute("error", "信息修改失败！");
                return "redirect:/reader_info.action";
            }
        }

    }

    @RequestMapping("reader_repasswd.action")
    public String readerRePasswd() {
        return "reader_repasswd";
    }

    @RequestMapping("reader_repasswd_do.action")
    public String readerRePasswdDo(HttpSession session, String oldPasswd, String newPasswd, String reNewPasswd,
                                   RedirectAttributes redirectAttributes) {
        ReaderCard readerCard = (ReaderCard) session.getAttribute("readercard");
        int readerId = readerCard.getReaderId();
        String passwd = readerCard.getPasswd();

        if (newPasswd.equals(reNewPasswd)) {
            if (passwd.equals(oldPasswd)) {
                boolean succ = readerCardService.updatePasswd(readerId, newPasswd);
                if (succ) {
                    ReaderCard readerCardNew = this.loginService.findReaderCardByUserId(readerId);
                    session.setAttribute("readercard", readerCardNew);
                    redirectAttributes.addFlashAttribute("succ", "密码修改成功！");
                    return "redirect:/reader_repasswd.action";
                } else {
                    redirectAttributes.addFlashAttribute("succ", "密码修改失败！");
                    return "redirect:/reader_repasswd.action";
                }

            } else {
                redirectAttributes.addFlashAttribute("error", "修改失败,原密码错误");
                return "redirect:/reader_repasswd.action";
            }
        } else {
            redirectAttributes.addFlashAttribute("error", "修改失败,两次输入的新密码不相同");
            return "redirect:/reader_repasswd.action";
        }

    }
}
