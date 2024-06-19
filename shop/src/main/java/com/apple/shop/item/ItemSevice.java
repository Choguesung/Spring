package com.apple.shop.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
@RequiredArgsConstructor
public class ItemSevice {

    private final ItemRepository itemRepository;

    public void saveItem(@ModelAttribute Item item){
        itemRepository.save(item);
    }

}
