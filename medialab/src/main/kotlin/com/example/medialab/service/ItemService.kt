package com.example.medialab.service

import com.example.medialab.model.Item
import com.example.medialab.repository.ItemRepository
import org.springframework.stereotype.Service

@Service
class ItemService(private val itemRepository: ItemRepository) {
    fun getAllItems(): List<Item> = itemRepository.findAll()

    fun getItemById(id: Long): Item = itemRepository.findById(id).orElseThrow { Exception("Item not found") }

    fun createItem(item: Item): Item = itemRepository.save(item)

    fun updateItem(id: Long, name: String, description: String): Item {
        val existingItem = getItemById(id)
        val updatedItem = existingItem.copy(
            name = name,
            description = description,
        )
        return itemRepository.save(updatedItem)
    }


    fun deleteItem(id: Long) = itemRepository.deleteById(id)
}