package com.code.bms.controller;

import com.code.bms.service.BookTypeService;
import com.code.bms.pojo.ClassInfo;
import com.code.bms.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookTypeController {
    @Autowired
    private BookTypeService bookTypeService;



    @RequestMapping("allBookType.action")
    public String allBookTypes(Model model, @RequestParam(defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "5") Integer pageSize) {
        PageResult<ClassInfo> bookTypes = this.bookTypeService.classInfos(pageNum, pageSize);
        model.addAttribute("bookTypes", bookTypes.getList());

        model.addAttribute("page", bookTypes);
        return "admin_bookType";
    }

    @RequestMapping("bookType_delete.action")
    public String bookTypeDelete(Integer classId, RedirectAttributes redirectAttributes) {
        boolean success = this.bookTypeService.deleteClassInfo(classId);

        if (success) {
            redirectAttributes.addFlashAttribute("succ", "删除成功！");
            return "redirect:/allBookType.action";
        } else {
            redirectAttributes.addFlashAttribute("error", "删除失败！");
            return "redirect:/allBookType.action";
        }
    }

    @RequestMapping("bookType_edit.action")
    public String bookTypeInfoEdit(Integer classId, Model model) {
        ClassInfo classInfo = bookTypeService.getClassInfo(classId);
        model.addAttribute("classInfo", classInfo);
        return "admin_bookType_edit";
    }

    @RequestMapping("bookType_edit_do.action")
    public String BookTypeInfoEditDo(ClassInfo classInfo, RedirectAttributes redirectAttributes) {
        boolean succ = this.bookTypeService.editBookType(classInfo);

        if (succ) {
            redirectAttributes.addFlashAttribute("succ", "读者修改成功！");
            return "redirect:/allBookType.action";
        } else {
            redirectAttributes.addFlashAttribute("error", "读者修改失败！");
            return "redirect:/allBookType.action";
        }
    }

    @RequestMapping("bookType_add.action")
    public String bookTypeInfoAdd() {
        return "admin_bookType_add";
    }

    @RequestMapping("bookType_add_do.action")
    public String BookTypeInfoAddDo(ClassInfo classInfo, RedirectAttributes redirectAttributes) {
        boolean succ = this.bookTypeService.addBookType(classInfo);
        if (succ) {
            redirectAttributes.addFlashAttribute("succ", "读者添加成功！");
            return "redirect:/allBookType.action";
        } else {
            redirectAttributes.addFlashAttribute("succ", "读者添加失败！");
            return "redirect:/allBookType.action";
        }
    }

}
