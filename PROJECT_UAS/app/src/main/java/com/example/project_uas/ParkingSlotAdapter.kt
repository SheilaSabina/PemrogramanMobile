package com.example.project_uas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ParkingSlotAdapter(private val slots: List<ParkingSlotModel>) :
    RecyclerView.Adapter<ParkingSlotAdapter.ParkingSlotViewHolder>() {

    inner class ParkingSlotViewHolder(val binding: ItemParkingSlotBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkingSlotViewHolder {
        val binding = ItemParkingSlotBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ParkingSlotViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ParkingSlotViewHolder, position: Int) {
        val slot = slots[position]
        with(holder.binding) {
            if (slot.isOccupied) {
                imgCar.visibility = View.VISIBLE
                layoutSlot.setBackgroundResource(R.drawable.bg_used_slot)
            } else {
                imgCar.visibility = View.INVISIBLE
                layoutSlot.setBackgroundResource(R.drawable.bg_empty_slot)
            }
        }
    }

    override fun getItemCount(): Int = slots.size
}