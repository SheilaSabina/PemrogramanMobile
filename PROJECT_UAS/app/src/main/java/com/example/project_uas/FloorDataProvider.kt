package com.example.project_uas

object FloorDataProvider {
    fun getDummySlots(): List<ParkingSlotModel> {
        val slots = mutableListOf<ParkingSlotModel>()
        for (i in 1..32) {
            slots.add(ParkingSlotModel("S$i", i % 2 == 0))
        }
        return slots
    }
}