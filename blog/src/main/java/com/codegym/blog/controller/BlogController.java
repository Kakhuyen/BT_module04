package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
// Lưu ý: Đã bỏ @RequestMapping("/blogs") ở đây
public class BlogController {

    @Autowired
    private BlogService blogService;

    // 1. Chức năng tự động chuyển hướng từ trang chủ
    @GetMapping("/")
    public String redirectHome() {
        return "redirect:/blogs";
    }

    // 2. Chức năng hiển thị danh sách
    @GetMapping("/blogs")
    public String listBlogs(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "index";
    }

    // 3. Chức năng hiển thị form tạo mới
    @GetMapping("/blogs/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    // 4. Chức năng lưu blog mới
    @PostMapping("/blogs/create")
    public String saveBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        return "redirect:/blogs";
    }

    // 5. Chức năng xem chi tiết
    @GetMapping("/blogs/view/{id}")
    public String viewBlog(@PathVariable("id") Long id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "view";
    }

    // 6. Chức năng hiển thị form sửa
    @GetMapping("/blogs/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "edit";
    }

    // 7. Chức năng cập nhật blog
    @PostMapping("/blogs/edit")
    public String updateBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        return "redirect:/blogs";
    }

    // 8. Chức năng hiển thị form xác nhận xóa
    @GetMapping("/blogs/delete/{id}")
    public String showDeleteForm(@PathVariable("id") Long id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "delete";
    }

    // 9. Chức năng xóa blog
    @PostMapping("/blogs/delete")
    public String deleteBlog(@ModelAttribute("blog") Blog blog) {
        blogService.remove(blog.getId());
        return "redirect:/blogs";
    }
}