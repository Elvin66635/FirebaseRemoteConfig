package olimp.bet.olimpbet.bk.app

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import olimp.bet.olimpbet.bk.app.adapter.CustomAdapter
import olimp.bet.olimpbet.bk.app.databinding.FragmentGymBinding
import olimp.bet.olimpbet.bk.app.databinding.FragmentWebBinding
import olimp.bet.olimpbet.model.ItemRowModel

class GymFragment : Fragment() {
    private var binding: FragmentGymBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentGymBinding.inflate(inflater, container, false)
        val recyclerview = binding?.recyclerview

        // this creates a vertical layout Manager
        recyclerview?.layoutManager = LinearLayoutManager(requireContext())

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemRowModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..20) {
            data.add(
                ItemRowModel(
                    R.drawable.otjimaniya_1__1_,
                    "Day 1: Chest, Biceps, Legs",
                    "Pushups \n" +
                            "\nThe first day of the training program is the most difficult. " +
                            "\nIt involves working on the two largest muscle groups of the body - the chest and legs.\n"
                )
            )
            data.add(ItemRowModel(
                R.drawable.svedeniya_na_grudi__1_, "Chest", "Pushups on the chest \n"
                        + "\nTry to tighten and bring your chest inward as much as possible, putting your hands forward - but without fixing your elbows." +
                        "\n2-3 sets of 12-15 reps"
            ))

            data.add(ItemRowModel(
                R.drawable.jim_stangi__1_, "Chest", "Bench Press \n" +
                        "\nWhen performing on a horizontal bench, do not lift your legs up. Optionally, the inclination of the bench can be varied every week. " +
                        "\n3-4 sets of 7-10 reps"
            ))

            data.add(ItemRowModel(
                R.drawable.shtanga_na_biceps__1_,
                "Biceps",
                "Barbell curls for biceps \n" +
                        "\nDo not sway when lifting the bar and keep your elbows in the same point." +
                        "\n 2-3 sets of 12-15 reps."
            ))

            data.add(ItemRowModel(
                R.drawable.podyem_na_biceps_icon__1_,
                "Biceps",
                "Biceps Curl with Scott Bench \n" +
                        "When doing lifts in the Scott bench, due to the additional fixation of the elbow, the load on the long head of the biceps is increased - plus, using a curved EZ bar will also help increase the level of involvement of muscle fibers. " +
                        "\n2-3 sets of 8-10 reps."
            ))
            data.add(ItemRowModel(
                R.drawable.prisedaniya_so_shtangoy__1_, "Legs", "Squats \n" +
                        "\nCan be done with a barbell or on a leg press machine. As you perform, keep your abs in conscious tension as you lower yourself to the point where your thighs are parallel to the floor. \n3-4 sets of 7-10 reps."
            ))
            data.add(ItemRowModel(
                R.drawable.razgibaniya_nog_v_trenajere,
                "Legs",
                "Leg extension in the simulator \n" +
                        "\nDon't help yourself lift the weight by arching your torso. Can be replaced with another leg exercise. \n2-3 sets of 12-15 reps"
            ))

            data.add(ItemRowModel(
                R.drawable.obratnie_razgibaniya_na_triceps,
                "Day 2: Shoulders, Triceps, Traps",
                "Reverse push-ups on the bench \n" +
                        "\nRound and voluminous shoulders will make the figure wider, and large triceps will increase the volume of the arms, visually expanding the biceps. \n" +
                        "\nAt the top point, try to push your body weight as high as possible. 2-3 sets of 12-15 reps."
            ))

            data.add(ItemRowModel(
                R.drawable.podyemy_ganteley_v_storony,
                "Shoulders",
                "Side dumbbell raises \n" +
                        "\nThe back should be straight, the arms should not bend at the elbows. Raise the weight to the horizontal. \n2-3 sets of 12-15 reps"
            ))
            data.add(ItemRowModel(
                R.drawable.poperemennie_podyemy,
                "Shoulders",
                "Front dumbbell raises \n" +
                        "\nUse medium weight dumbbells and watch your technique. Start raising your hand only when the opposite hand is at the bottom of the movement. \n2-3 sets of 12-15 reps"
            ))
            data.add(ItemRowModel(
                R.drawable.jim_ganteley_sidya, "Shoulders", "Seated Dumbbell Press \n" +
                        "\nWhen performing, keep the press in conscious tension, when lifting the weight up, do not push it out due to the strength of the body - only the shoulders work. \n3-4 sets of 7-10 reps"
            ))
                data.add(ItemRowModel(
                R.drawable.ganteli_k_podborodku,
                "Shoulders",
                "Lifting dumbbells to the chin \n" +
                        "\nPerform the exercise slowly, involving as many muscle fibers as possible. \n2-3 sets of 12-15 reps"
            ))
            data.add(ItemRowModel(
                R.drawable.jim_na_triceps_iz_za_golovy,
                "Triceps",
                "Triceps press from behind the head \n" +
                        "\nElbows should be parallel to each other and should not move to the side when moving the weight. Can be replaced with another triceps exercise. \n3-4 sets of 7-10 reps"
            ))

                data.add(ItemRowModel(
                R.drawable.podtyagivaniya_1, "Day 3: Back and Abs", "Pull-ups \n" +
                        "\nWhen performing, keep the press in conscious tension, and at the top point, feel the work of the back muscles, pushing the body weight higher. \nDon't swing. 2-3 sets of 12-15 reps."
            ))
                    data.add(ItemRowModel(
                R.drawable.tyaga_verhnego_bloka_1, "Back", "Top block pull \n" +
                        "\nUsing different handles and grips allows you to modify the exercise and engage different back muscles. \n3-4 sets of 7-10 reps"
            ))
                        data.add(ItemRowModel(
                R.drawable.skruchivaniya_na_skamye,
                "Back",
                "Dumbbell pull to the belt \n" +
                        "\nWhen lifting up, do not hold your breath and do not make sure that the load does not pass to the lower back and lower back. In increased concentration, tighten the press even more. \n3-4 takes 10-15 reps"
            ))
            data.add(ItemRowModel(
                R.drawable.uprajnenie_velosiped, "Abs", "Bicycle on the press \n" +
                        "\nIt involves bending the leg at the knee and bringing the opposite elbow to it. It is performed with a tense press and with a full feeling of involvement of the abdominal muscles in the work. \n3-4 sets of 10-15 reps."
            ))
            ItemRowModel(
                R.drawable.planka, "Abs", "Plank \n" +
                        "\nThe bar is performed in a static mode - it is necessary not to repeat the movement, but to linger motionless. Alternate different types (on the elbows, on outstretched arms, side). 3-4 sets of 60-90 sec."
            )
        }

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview?.adapter = adapter


        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
        activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

    }

    override fun onPause() {
        super.onPause()
        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        // Clear the systemUiVisibility flag
        activity?.window?.decorView?.systemUiVisibility = 0
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}