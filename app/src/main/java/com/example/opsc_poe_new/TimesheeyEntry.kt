package com.example.opsc_poe_new

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class TimesheeyEntry : AppCompatActivity() {
    var dialog: Dialog? = null
    var editText: EditText? = null
    var delete_subject: Button? = null
    var add_subject: Button? = null
    var timetable_subject: String? = null
    private lateinit var photoImageView: ImageView
    private lateinit var addPhotoButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timesheet)
        dialog = Dialog(this@TimesheeyEntry)
        dialog!!.setContentView(R.layout.popup_window);
        dialog!!.window!!.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        editText= dialog!!.findViewById(R.id.po);
        add_subject= dialog!!.findViewById(R.id.add_subject);
        delete_subject= dialog!!.findViewById(R.id.delete_subject);
        photoImageView = dialog!!.findViewById(R.id.photoImageView)
        addPhotoButton = dialog!!.findViewById(R.id.addPhotoButton)

        addPhotoButton.setOnClickListener(View.OnClickListener {
            // Create an Intent to open the camera or gallery
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, IMAGE_PICK_REQUEST_CODE)
        })

        val Sun1 = findViewById(R.id.Sunday1) as TextView
        val Sun2 = findViewById(R.id.Sunday2) as TextView
        val Sun3 = findViewById(R.id.Sunday3) as TextView
        val Sun4 = findViewById(R.id.Sunday4) as TextView
        val Sun5 = findViewById(R.id.Sunday5) as TextView
        val Sun6 = findViewById(R.id.Sunday6) as TextView
        val Sun7 = findViewById(R.id.Sunday7) as TextView
        val Sun8 = findViewById(R.id.Sunday8) as TextView
        val Sun9 = findViewById(R.id.Sunday9) as TextView

        val Mon1 = findViewById(R.id.Monday1) as TextView
        val Mon2 = findViewById(R.id.Monday2) as TextView
        val Mon3 = findViewById(R.id.Monday3) as TextView
        val Mon4 = findViewById(R.id.Monday4) as TextView
        val Mon5 = findViewById(R.id.Monday5) as TextView
        val Mon6 = findViewById(R.id.Monday6) as TextView
        val Mon7 = findViewById(R.id.Monday7) as TextView
        val Mon8 = findViewById(R.id.Monday8) as TextView
        val Mon9 = findViewById(R.id.Monday9) as TextView

        val Tue1 = findViewById(R.id.Tuesday1) as TextView
        val Tue2 = findViewById(R.id.Tuesday2) as TextView
        val Tue3 = findViewById(R.id.Tuesday3) as TextView
        val Tue4 = findViewById(R.id.Tuesday4) as TextView
        val Tue5 = findViewById(R.id.Tuesday5) as TextView
        val Tue6 = findViewById(R.id.Tuesday6) as TextView
        val Tue7 = findViewById(R.id.Tuesday7) as TextView
        val Tue8 = findViewById(R.id.Tuesday8) as TextView
        val Tue9 = findViewById(R.id.Tuesday9) as TextView

        val Wed1 = findViewById(R.id.Wednesday1) as TextView
        val Wed2 = findViewById(R.id.Wednesday2) as TextView
        val Wed3 = findViewById(R.id.Wednesday3) as TextView
        val Wed4 = findViewById(R.id.Wednesday4) as TextView
        val Wed5 = findViewById(R.id.Wednesday5) as TextView
        val Wed6 = findViewById(R.id.Wednesday6) as TextView
        val Wed7 = findViewById(R.id.Wednesday7) as TextView
        val Wed8 = findViewById(R.id.Wednesday8) as TextView
        val Wed9 = findViewById(R.id.Wednesday9) as TextView

        val Thu1 = findViewById(R.id.Thursday1) as TextView
        val Thu2 = findViewById(R.id.Thursday2) as TextView
        val Thu3 = findViewById(R.id.Thursday3) as TextView
        val Thu4 = findViewById(R.id.Thursday4) as TextView
        val Thu5 = findViewById(R.id.Thursday5) as TextView
        val Thu6 = findViewById(R.id.Thursday6) as TextView
        val Thu7 = findViewById(R.id.Thursday7) as TextView
        val Thu8 = findViewById(R.id.Thursday8) as TextView
        val Thu9 = findViewById(R.id.Thursday9) as TextView

        val Fri1 = findViewById(R.id.Friday1) as TextView
        val Fri2 = findViewById(R.id.Friday2) as TextView
        val Fri3 = findViewById(R.id.Friday3) as TextView
        val Fri4 = findViewById(R.id.Friday4) as TextView
        val Fri5 = findViewById(R.id.Friday5) as TextView
        val Fri6 = findViewById(R.id.Friday6) as TextView
        val Fri7 = findViewById(R.id.Friday7) as TextView
        val Fri8 = findViewById(R.id.Friday8) as TextView
        val Fri9 = findViewById(R.id.Friday9) as TextView

        val Sat1 = findViewById(R.id.Saturday1) as TextView
        val Sat2 = findViewById(R.id.Saturday2) as TextView
        val Sat3 = findViewById(R.id.Saturday3) as TextView
        val Sat4 = findViewById(R.id.Saturday4) as TextView
        val Sat5 = findViewById(R.id.Saturday5) as TextView
        val Sat6 = findViewById(R.id.Saturday6) as TextView
        val Sat7 = findViewById(R.id.Saturday7) as TextView
        val Sat8 = findViewById(R.id.Saturday8) as TextView
        val Sat9 = findViewById(R.id.Saturday9) as TextView

        //Sun1.setOnClickListener(View.OnClickListener { show(Sun1, "Saturday3") })
        Sun1.setOnClickListener(View.OnClickListener { show(Sun1, "Sunday1") })
        Sun2.setOnClickListener(View.OnClickListener { show(Sun2, "Sunday2") })
        Sun3.setOnClickListener(View.OnClickListener { show(Sun3, "Sunday3") })
        Sun4.setOnClickListener(View.OnClickListener { show(Sun4, "Sunday4") })
        Sun5.setOnClickListener(View.OnClickListener { show(Sun5, "Sunday5") })
        Sun6.setOnClickListener(View.OnClickListener { show(Sun6, "Sunday6") })
        Sun7.setOnClickListener(View.OnClickListener { show(Sun7, "Sunday7") })
        Sun8.setOnClickListener(View.OnClickListener { show(Sun8, "Sunday8") })
        Sun9.setOnClickListener(View.OnClickListener { show(Sun9, "Sunday9") })

        Mon1.setOnClickListener(View.OnClickListener { show(Mon1, "Monday1") })
        Mon2.setOnClickListener(View.OnClickListener { show(Mon2, "Monday2") })
        Mon3.setOnClickListener(View.OnClickListener { show(Mon3, "Monday3") })
        Mon4.setOnClickListener(View.OnClickListener { show(Mon4, "Monday4") })
        Mon5.setOnClickListener(View.OnClickListener { show(Mon5, "Monday5") })
        Mon6.setOnClickListener(View.OnClickListener { show(Mon6, "Monday6") })
        Mon7.setOnClickListener(View.OnClickListener { show(Mon7, "Monday7") })
        Mon8.setOnClickListener(View.OnClickListener { show(Mon8, "Monday8") })
        Mon9.setOnClickListener(View.OnClickListener { show(Mon9, "Monday9") })


        Tue1.setOnClickListener(View.OnClickListener { show(Tue1, "Tuesday1") })
        Tue2.setOnClickListener(View.OnClickListener { show(Tue2, "Tuesday2") })
        Tue3.setOnClickListener(View.OnClickListener { show(Tue3, "Tuesday3") })
        Tue4.setOnClickListener(View.OnClickListener { show(Tue4, "Tuesday4") })
        Tue5.setOnClickListener(View.OnClickListener { show(Tue5, "Tuesday5") })
        Tue6.setOnClickListener(View.OnClickListener { show(Tue6, "Tuesday6") })
        Tue7.setOnClickListener(View.OnClickListener { show(Tue7, "Tuesday7") })
        Tue8.setOnClickListener(View.OnClickListener { show(Tue8, "Tuesday8") })
        Tue9.setOnClickListener(View.OnClickListener { show(Tue9, "Tuesday9") })


        Wed1.setOnClickListener(View.OnClickListener { show(Wed1, "Wednesday1") })
        Wed2.setOnClickListener(View.OnClickListener { show(Wed2, "Wednesday2") })
        Wed3.setOnClickListener(View.OnClickListener { show(Wed3, "Wednesday3") })
        Wed4.setOnClickListener(View.OnClickListener { show(Wed4, "Wednesday4") })
        Wed5.setOnClickListener(View.OnClickListener { show(Wed5, "Wednesday5") })
        Wed6.setOnClickListener(View.OnClickListener { show(Wed6, "Wednesday6") })
        Wed7.setOnClickListener(View.OnClickListener { show(Wed7, "Wednesday7") })
        Wed8.setOnClickListener(View.OnClickListener { show(Wed8, "Wednesday8") })
        Wed9.setOnClickListener(View.OnClickListener { show(Wed9, "Wednesday9") })


        Thu1.setOnClickListener(View.OnClickListener { show(Thu1, "Thursday1") })
        Thu2.setOnClickListener(View.OnClickListener { show(Thu2, "Thursday2") })
        Thu3.setOnClickListener(View.OnClickListener { show(Thu3, "Thursday3") })
        Thu4.setOnClickListener(View.OnClickListener { show(Thu4, "Thursday4") })
        Thu5.setOnClickListener(View.OnClickListener { show(Thu5, "Thursday5") })
        Thu6.setOnClickListener(View.OnClickListener { show(Thu6, "Thursday6") })
        Thu7.setOnClickListener(View.OnClickListener { show(Thu7, "Thursday7") })
        Thu8.setOnClickListener(View.OnClickListener { show(Thu8, "Thursday8") })
        Thu9.setOnClickListener(View.OnClickListener { show(Thu9, "Thursday9") })


        Fri1.setOnClickListener(View.OnClickListener { show(Fri1, "Friday1") })
        Fri2.setOnClickListener(View.OnClickListener { show(Fri2, "Friday2") })
        Fri3.setOnClickListener(View.OnClickListener { show(Fri3, "Friday3") })
        Fri4.setOnClickListener(View.OnClickListener { show(Fri4, "Friday4") })
        Fri5.setOnClickListener(View.OnClickListener { show(Fri5, "Friday5") })
        Fri6.setOnClickListener(View.OnClickListener { show(Fri6, "Friday6") })
        Fri7.setOnClickListener(View.OnClickListener { show(Fri7, "Friday7") })
        Fri8.setOnClickListener(View.OnClickListener { show(Fri8, "Friday8") })
        Fri9.setOnClickListener(View.OnClickListener { show(Fri9, "Friday9") })


        Sat1.setOnClickListener(View.OnClickListener { show(Sat1, "Saturday1") })
        Sat2.setOnClickListener(View.OnClickListener { show(Sat2, "Saturday2") })
        Sat3.setOnClickListener(View.OnClickListener { show(Sat3, "Saturday3") })
        Sat4.setOnClickListener(View.OnClickListener { show(Sat4, "Saturday4") })
        Sat5.setOnClickListener(View.OnClickListener { show(Sat5, "Saturday5") })
        Sat6.setOnClickListener(View.OnClickListener { show(Sat6, "Saturday6") })
        Sat7.setOnClickListener(View.OnClickListener { show(Sat7, "Saturday7") })
        Sat8.setOnClickListener(View.OnClickListener { show(Sat8, "Saturday8") })
        Sat9.setOnClickListener(View.OnClickListener { show(Sat9, "Saturday9") })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == IMAGE_PICK_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            // Handle the selected image
            val selectedImageUri = data.data
            val bitmap: Bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, selectedImageUri)

            // Display the selected image in the ImageView
            photoImageView.setImageBitmap(bitmap)
        }
    }

    companion object {
        private const val IMAGE_PICK_REQUEST_CODE = 1001
    }

    fun show(textView: TextView?, dayname: String?) {
        timetable_subject = null
        dialog!!.show()
        add_subject!!.setOnClickListener {
            timetable_subject = editText!!.text.toString()
            if (timetable_subject!!.isEmpty()) {
                editText!!.requestFocus()
                editText!!.error = "field is empty"
            } else {
                //HashMap<String, Object> values = new HashMap<>();
                //values.put(dayname, timetable_subject);
                //databaseStudents.child(user.getUid()).updateChildren(values);
                textView!!.text = timetable_subject
                editText!!.setText("")
                dialog!!.dismiss()
            }
        }
        delete_subject!!.setOnClickListener { //databaseStudents.child(user.getUid()).child(dayname).removeValue();
            textView!!.text = ""
            dialog!!.dismiss()
        }
    }
}