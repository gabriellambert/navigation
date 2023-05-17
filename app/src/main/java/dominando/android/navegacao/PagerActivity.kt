package dominando.android.navegacao

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dominando.android.navegacao.databinding.ActivityPageBinding

class PagerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tabsPagerAdapter = TabsPagerAdapter(this, supportFragmentManager)
        binding.viewPager.adapter = tabsPagerAdapter
    }
}