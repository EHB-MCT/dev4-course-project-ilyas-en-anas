package com.example.medialab.controller

import com.example.medialab.model.Item
import com.example.medialab.service.ItemService
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/api/items")
class ItemController(private val itemService: ItemService) {
    @GetMapping("")
    fun getAllItems(): List<Item> = itemService.getAllItems()

    @GetMapping("/{id}")
    fun getItemById(@PathVariable id: Long): Item = itemService.getItemById(id)

    @PostMapping("")
    fun createItem(@RequestBody item: Item): Item = itemService.createItem(item)

    @PutMapping("/{id}")
    fun updateItem(@PathVariable id: Long, @RequestBody item: Item): Item =
        itemService.updateItem(id, item.name, item.description)

    @DeleteMapping("/{id}")
    fun deleteItem(@PathVariable id: Long) = itemService.deleteItem(id)
}