package com.example.medialab.controller

import com.example.medialab.service.ItemService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/items")
class ItemController(private val itemService: ItemService) {
}