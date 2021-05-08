package com.example.mymiwok

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import java.io.ByteArrayOutputStream

open class MainActivity : AppCompatActivity() {
    val bundle = Bundle()


    val numbersEnglish = arrayListOf(
        "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"
    )
    val numbersMiwok = arrayListOf(
        "lutti",
        "otiiko",
        "tolookosu",
        "oyyisa",
        "massokka",
        "temmokka",
        "kenekaku",
        "kawinta",
        "wo'e",
        "na'aacha"
    )


    val familyEnglish = arrayListOf(
        "father",
        "mother",
        "son",
        "daughter",
        "older brother",
        "younger brother",
        "older sister",
        "younger sister",
        "grandmother",
        "grandfather"
    )
    val familyMiwok = arrayListOf(
        "әpә",
        "әṭa", "angsi", "tune", "taachi", "chalitti", "teṭe", "kolliti", "ama", "paapa"
    )

    val colorsEnglish = arrayListOf(
        "red", "green", "brown", "gray", "black", "white", "dusty yellow", "mustard yellow"
    )
    val colorsMiwok = arrayListOf(
        "weṭeṭṭi", "chokokki", "ṭakaakki", "ṭopoppi", "kululli", "kelelli", "ṭopiisә", "chiwiiṭә"
    )

    val phrasesEnglish = arrayListOf(
        "Where are you going?",
        "What is your name?",
        "My name is...",
        "How are you feeling?",
        "I’m feeling good.",
        "Are you coming?",
        "Yes, I’m coming.",
        "I’m coming.",
        "Let’s go.",
        "Come here."
    )
    val phrasesMiwok = arrayListOf(
        "minto wuksus", "tinnә oyaase'nә", "oyaaset...", "michәksәs?", "kuchi achit",
        "әәnәs'aa?", "hәә’ әәnәm", "әәnәm", "yoowutis", "әnni'nem"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val tabs = findViewById<TabLayout>(R.id.tabs)


        val adapter = ViewPagerAdapter(supportFragmentManager)



        adapter.addFragment(ScreenFragment(), "numbers", bundle)
        adapter.addFragment(ScreenFragment(), "family", bundle)
        adapter.addFragment(ScreenFragment(), "colors", bundle)
        adapter.addFragment(ScreenFragment(), "phrases", bundle)
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }


    inner class ViewPagerAdapter(manager: FragmentManager) :
        FragmentStatePagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        private val fragmentList: MutableList<Fragment> = ArrayList()
        private val titleList: MutableList<String> = ArrayList()
        private var frag: Fragment = Fragment()
        override fun getItem(position: Int): Fragment {
            if (position == 0) {
                frag = fragmentList[0]
                bundle.putStringArrayList("english", ArrayList<String>(numbersEnglish))
                bundle.putStringArrayList("miwok", ArrayList<String>(numbersMiwok))
                return frag
            } else if (position == 1) {
                frag = fragmentList[1]
                bundle.putStringArrayList("english", ArrayList<String>(familyEnglish))
                bundle.putStringArrayList("miwok", ArrayList<String>(familyMiwok))
                return frag
            } else if (position == 2) {
                frag = fragmentList[2]
                bundle.putStringArrayList("english", ArrayList<String>(colorsEnglish))
                bundle.putStringArrayList("miwok", ArrayList<String>(colorsMiwok))
                return frag
            } else if (position == 3) {
                frag = fragmentList[3]
                bundle.putStringArrayList("english", ArrayList<String>(phrasesEnglish))
                bundle.putStringArrayList("miwok", ArrayList<String>(phrasesMiwok))
                return frag
            } else return frag
        }




    override fun getCount(): Int {
        return fragmentList.size
    }

    fun addFragment(fragment: ScreenFragment, title: String, args: Bundle) {
        fragment.arguments = args
        fragmentList.add(fragment)
        titleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }

}
}




