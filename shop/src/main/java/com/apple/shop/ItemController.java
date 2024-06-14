package com.apple.shop;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;

    @GetMapping("/list")
    String list(Model model) {
        List<Item> result = itemRepository.findAll();
        model.addAttribute("items", result);

        return "list.html";
    }

    @GetMapping("/write")
    String write() {
        return "write.html";
    }

    // 상품 추가 기능임
    @PostMapping("/add")
    String addPost(@ModelAttribute Item item) {

        itemRepository.save(item);

        return "redirect:/list";
    }

    @GetMapping("detail/{id}")
    String detail(@PathVariable Long id, Model model){
        Optional<Item> result = itemRepository.findById(id);
        if( result.isPresent() ){
            model.addAttribute("data",result.get());
            return "detail.html";
        } else {
            return "redirect:/list";
        }
    }

}
