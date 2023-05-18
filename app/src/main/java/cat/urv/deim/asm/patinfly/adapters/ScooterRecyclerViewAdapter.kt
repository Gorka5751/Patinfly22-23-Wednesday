package cat.urv.deim.asm.patinfly.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import cat.urv.deim.asm.patinfly.R
import cat.urv.deim.asm.patinfly.models.Scooters
import cat.urv.deim.asm.patinfly.persistence.Scooter
import cat.urv.deim.asm.patinfly.views.principal.PrincipalActivity
import cat.urv.deim.asm.patinfly.views.scooter.ScooterDetailActivity
import cat.urv.deim.asm.patinfly.views.signup.SignupActivity


class ScooterRecyclerViewAdapter(private var scooters: Scooters) :
    RecyclerView.Adapter<ScooterRecyclerViewAdapter.ViewHolder>() {


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textView: TextView
        val BatteryView: TextView


        val root: View

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.textView)
            BatteryView= view.findViewById(R.id.BatteryView)

            root = view

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.activity_scooter_detail, viewGroup, false)

        return ViewHolder(view)
    }


    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element


        if(scooters.scooters.get(position).state == "ACTIVE"){
            viewHolder.textView.text = scooters.scooters.get(position).name
            viewHolder.BatteryView.text = "Battery: " + scooters.scooters.get(position).battery_level.toString() + "%"
        }else{
            viewHolder.textView.text = "NO DISPONIBLE"
            viewHolder.BatteryView.text=""
        }

        viewHolder.root.setOnClickListener {
            val intent = Intent(viewHolder.root.context, ScooterDetailActivity::class.java)
            viewHolder.root.context.startActivity(intent)
        }

    }
  //  fun scooterUpdate(scooters: List<Scooter>){
   //     this.scooters=scooters
   //     this.notifyDataSetChanged()
    //}

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = scooters.scooters.size




}
