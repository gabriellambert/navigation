package dominando.android.navegacao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dominando.android.navegacao.databinding.ActivityMainBinding
import dominando.android.navegacao.databinding.ActivityTabsBinding

class TabsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTabsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTabsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(findViewById(R.id.toolbar))
        val pagerAdapter = TabsPagerAdapter(this, supportFragmentManager)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.viewPager.adapter = pagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}