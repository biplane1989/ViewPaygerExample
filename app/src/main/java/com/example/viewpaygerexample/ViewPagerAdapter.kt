package com.example.viewpaygerexample

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide

class ViewPagerAdapter() : PagerAdapter() {

    var urls = ArrayList<Int>()
    override fun getCount(): Int {
        return urls.size
    }

    fun setList(url: List<Int>){
        this.urls = url as ArrayList<Int>
    }

    override fun isViewFromObject(view: View, object1: Any): Boolean {
        return view == object1
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        // Tạo ImageView, container chính là ViewPager của chúng ta
        val context = container.context
        val imageView = AppCompatImageView(context)
        container.addView(imageView)
        // Load ảnh vào ImageView bằng Glide
        Glide.with(context).load(urls[position]).into(imageView)
        // Return
        return imageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, object1: Any) {
        // container chính là ViewPager, còn Object chính là return của instantiateItem ứng với position
        container.removeView(object1 as View)
    }

}