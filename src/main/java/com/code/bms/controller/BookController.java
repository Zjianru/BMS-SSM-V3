package com.code.bms.controller;

import com.code.bms.service.BookService;
import com.code.bms.pojo.BookInfo;
import com.code.bms.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/allbooks.action")
    public String allBook(Model model,@RequestParam(defaultValue="1")Integer pageNum,
                          @RequestParam(defaultValue="5")Integer pageSize) {

        PageResult<BookInfo> books = this.bookService.getAllBooks(pageNum, pageSize);
        model.addAttribute("books", books.getList());
        model.addAttribute("page",books);
        return "admin_books";
    }

    @RequestMapping("/querybook.action")
    public String queryBookDo(String searchWord, Model model) {
        boolean exist = this.bookService.matchBook(searchWord);
        if (exist) {
            List<BookInfo> books = this.bookService.queryBook(searchWord);
            model.addAttribute("books", books);
            return "admin_books";
        } else {
            model.addAttribute("error", "没有匹配的图书");
            return "admin_books";
        }
    }

    @RequestMapping("/book_add.action")
    public String addBook() {
        return "admin_book_add";

    }

    @RequestMapping("/book_add_do.action")
    public String addBookDo(BookInfo bookInfo, RedirectAttributes redirectAttributes) {

        boolean succ = this.bookService.addBook(bookInfo);
        if (succ) {
            redirectAttributes.addFlashAttribute("succ", "图书添加成功！");
            return "redirect:/allbooks.action";
        } else {
            redirectAttributes.addFlashAttribute("succ", "图书添加失败！");
            return "redirect:/allbooks.action";
        }
    }

    @RequestMapping("/bookdetail.action")
    public String bookDetail(Long bookId, Model model) {
        BookInfo book = this.bookService.getBook(bookId);
        model.addAttribute("detail", book);
        return "admin_book_detail";
    }

    @RequestMapping("/updatebook.action")
    public String bookEdit(Long bookId, Model model) {
        BookInfo book = this.bookService.getBook(bookId);
        model.addAttribute("detail", book);
        return "admin_book_edit";
    }

    @RequestMapping("/book_edit_do.action")
    public String bookEditDo(BookInfo bookInfo, RedirectAttributes redirectAttributes) {
        boolean succ = this.bookService.editBook(bookInfo);

        if (succ) {
            redirectAttributes.addFlashAttribute("succ", "图书修改成功！");
            return "redirect:/allbooks.action";
        } else {
            redirectAttributes.addFlashAttribute("error", "图书修改失败！");
            return "redirect:/allbooks.action";
        }
    }

    @RequestMapping("/deletebook.action")
    public String deleteBook(Long bookId, RedirectAttributes redirectAttributes) {
        int res = bookService.deleteBook(bookId);

        if (res == 1) {
            redirectAttributes.addFlashAttribute("succ", "图书删除成功！");
            return "redirect:/allbooks.action";
        } else {
            redirectAttributes.addFlashAttribute("error", "图书删除失败！");
            return "redirect:/allbooks.action";
        }
    }

    @RequestMapping("/reader_querybook.action")
    public String readerQueryBook() {
        return "reader_book_query";

    }

    @RequestMapping("/reader_querybook_do.action")
    public String readerQueryBookDo(String searchWord, RedirectAttributes redirectAttributes) {
        boolean exist = bookService.matchBook(searchWord);
        if (exist) {
            List<BookInfo> books = bookService.queryBook(searchWord);
            redirectAttributes.addFlashAttribute("books", books);
            return "redirect:/reader_querybook.action";
        } else {
            redirectAttributes.addFlashAttribute("error", "没有匹配的图书！");
            return "redirect:/reader_querybook.action";
        }

    }

    @RequestMapping("/readerbookdetail.action")
    public String readerBookDetail(Long bookId, Model model) {
        BookInfo book = bookService.getBook(bookId);
        model.addAttribute("detail", book);
        return "reader_book_detail";
    }

    @RequestMapping("/toplist.action")
    @ResponseBody
    @CrossOrigin
    public List<BookInfo> topList() {
	    return bookService.getTopBooks();
    }
}