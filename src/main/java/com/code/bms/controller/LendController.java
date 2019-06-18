package com.code.bms.controller;

import com.code.bms.service.BookService;
import com.code.bms.service.LendService;
import com.code.bms.pojo.BookInfo;
import com.code.bms.pojo.LendList;
import com.code.bms.pojo.PageResult;
import com.code.bms.pojo.ReaderCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.List;

@Controller
public class LendController {
    @Autowired
    private LendService lendService;

    @Autowired
    private BookService bookService;

    @RequestMapping("/mylend.action")
    public String myLend(HttpSession session, Model model) {
        ReaderCard readerCard = (ReaderCard) session.getAttribute("readercard");
        List<LendList> list = this.lendService.myLendList(readerCard.getReaderId());
        model.addAttribute("list", list);
        return "reader_lend_list";
    }

    @RequestMapping("/lendlist.action")
    public String lendList(Model model,@RequestParam(defaultValue="1")Integer pageNum,
                           @RequestParam(defaultValue="5")Integer pageSize) {
        PageResult<LendList> list = this.lendService.lendList(pageNum, pageSize);
        model.addAttribute("list", list.getList());
        model.addAttribute("page",list);
        return "admin_lend_list";
    }

    @RequestMapping("/deletelog.action")
    public String deleteLog(Long sernum, RedirectAttributes redirectAttributes) {
        boolean success = this.lendService.deleteLog(sernum);
        if (success) {
            redirectAttributes.addFlashAttribute("succ", "删除成功！");
            return "redirect:/lendlist.action";
        } else {
            redirectAttributes.addFlashAttribute("error", "删除失败！");
            return "redirect:/lendlist.action";
        }
    }

    @RequestMapping("/querylog.action")
    public String queryLog(Integer searchWord, Model model) {
        boolean exist = this.lendService.matchLog(searchWord);
        if (exist) {
            List<LendList> list = this.lendService.myLendList(searchWord);
            model.addAttribute("list", list);
            return "admin_lend_list";
        } else {
            model.addAttribute("error", "该读者没有借还信息");
            return "admin_lend_list";
        }
    }

    @RequestMapping("/lendbook.action")
    public String bookLend(Long bookId, Model model) {
        BookInfo book = this.bookService.getBook(bookId);
        model.addAttribute("book", book);
        return "admin_book_lend";
    }

    @RequestMapping("/lendbookdo.action")
    public String bookLendDo(Long bookId, Integer readerId, RedirectAttributes redirectAttributes) {
        boolean lendsucc = this.lendService.bookLend(bookId, readerId);
        if (lendsucc) {
            redirectAttributes.addFlashAttribute("succ", "图书借阅成功！");
            return "redirect:/allbooks.action";
        } else {
            redirectAttributes.addFlashAttribute("succ", "图书借阅成功！");
            return "redirect:/allbooks.action";
        }

    }

    @RequestMapping("/returnbook.action")
    public String bookReturn(Long bookId, RedirectAttributes redirectAttributes) {
        boolean retSucc = lendService.bookReturn(bookId);
        if (retSucc) {
            redirectAttributes.addFlashAttribute("succ", "图书归还成功！");
            return "redirect:/allbooks.action";
        } else {
            redirectAttributes.addFlashAttribute("error", "图书归还失败！");
            return "redirect:/allbooks.action";
        }
    }
    @CrossOrigin
    @RequestMapping("/checklend.action")
    public Integer checkLend(HttpSession session) {
        Enumeration attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()){
            System.out.println(attributeNames.nextElement());
        }
        ReaderCard readerCard = (ReaderCard) session.getAttribute("readercard");
        int count = 0;
        List<LendList> lendLists = lendService.myLendList(readerCard.getReaderId());
        for (LendList len : lendLists) {
            if (len.getBackDate() == null){
                count ++;
            }
        }
        return count;
    }

}

