package com.codegym.dictionary;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {

    private static Map<String, String> dictionary;

    static {

        dictionary = new HashMap<>();

        dictionary.put("hello", "Xin chào");

        dictionary.put("book", "Quyển sách");

        dictionary.put("computer", "Máy tính");

        dictionary.put("dog", "Con chó");

        dictionary.put("cat", "Con mèo");
    }

    @GetMapping("/")
    public String showForm() {

        return "index";
    }

    @GetMapping("/search")
    public String search(

            @RequestParam("word") String word,

            Model model) {

        String result = dictionary.get(word);

        if (result == null) {

            result = "Không tìm thấy từ";

        }

        model.addAttribute("word", word);

        model.addAttribute("result", result);

        return "result";
    }
}