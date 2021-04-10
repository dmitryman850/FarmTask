package dmitry.man.farmapplication

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Main2Activity : AppCompatActivity() {

    private var toolbar: ActionBar? = null
    private val homeFragment = HomeFragment.newInstance()

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.main_action_archive -> {
                    val archiveFragment = ArchiveFragment.newInstance()
                    openFragment(archiveFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.main_action_home -> {
                    openFragment(homeFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.main_action_settings -> {
                    val settingsFragment = SettingsFragment.newInstance()
                    openFragment(settingsFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            true
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        openFragment(homeFragment)

        toolbar = supportActionBar
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bnv_main2_fragment)
        bottomNavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        bottomNavigation.menu.findItem(R.id.main_action_home).isChecked = true
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container_activity_main2, fragment)
            commit()
        }
    }
}