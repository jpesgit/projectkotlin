package com.example.joaopedrosilva.projectkotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

/**\
 * 1: Line breaks na class declaration se implementar mts interfaces. Neste caso pode ficar num linha só
 * 2: Ordem dos métodos:
 * -- lifecycle methods
 * -- implemented methods
 * -- public methods
 * -- private methods
 * -- extension functions
 *
 * 3: podes converter o setText para text = ...
 * 4: extension function definidas na classe devem ser private. por a extensão num ficheiro á parte (top level func)
 * 5: login private?
 * 6: startActivity = a 4
 */
class MainActivity :
        AppCompatActivity(),
        View.OnClickListener {
    override fun onClick(v: View?) {
        login(etUsername.text.toString(), etPassword.text.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        welcomeMessage.setText(getString(R.string.app_name))
        buttonLogin.setOnClickListener(this)


    }

    /**
     * Extensions Functions permitem adicionar novas funções às classes existentes
     *
     */
    fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, duration).show()
    }


    fun login(user: String, pass: String) {
        if (user == "a" && pass == "a") {
            toast("success")
            startActivity<SecondActivity>()
        } else {
            toast("try again")
        }
    }

    /**
     * reified functions
     */
    inline fun <reified T : Activity> Activity.startActivity() {
        startActivity(Intent(this, T::class.java))
    }
}
