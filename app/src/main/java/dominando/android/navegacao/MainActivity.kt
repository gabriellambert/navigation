package dominando.android.navegacao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentTransaction
import dominando.android.navegacao.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val drawerToggle: ActionBarDrawerToggle by lazy {
        ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            findViewById(R.id.toolbar),
            R.string.app_name,
            R.string.app_name
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        binding.navigationView.setNavigationItemSelectedListener { menuItem ->
            selectMenuOption(menuItem)
            true
        }
        if (savedInstanceState == null) {
            selectMenuOption(binding.navigationView.menu.findItem(R.id.action_tab))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                binding.drawerLayout.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun selectMenuOption(menuItem: MenuItem) {
        menuItem.isChecked = true
        binding.drawerLayout.closeDrawers()
        val title = menuItem.title.toString()
        val fragment = FirstLevelFragment.newInstance(title)
        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.content, fragment, title)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        transaction.addToBackStack(null)
        if (supportFragmentManager.findFragmentByTag(title) == null) {
            val firstLevelFragment = FirstLevelFragment.newInstance(title)
            supportFragmentManager.beginTransaction()
                .replace(R.id.content, firstLevelFragment, title).commit()
        }
    }
}