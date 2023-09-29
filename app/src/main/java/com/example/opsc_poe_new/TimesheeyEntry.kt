package com.example.opsc_poe_new

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class TimesheeyEntry : AppCompatActivity() {
    var dialog: Dialog? = null
    var dialog2: Dialog? = null
    var editText: EditText? = null
    var delete_subject: Button? = null
    var add_subject: Button? = null
    var viewCat: Button? = null
    var viewEnt: Button? = null
    var tBack: Button? = null
    var timetable_subject: String? = null
    var cTxt: String? = null
    var globalVariable = GlobalClass();
    private lateinit var photoImageView: ImageView
    private lateinit var addPhotoButton: Button
    var categoryText: EditText? = null
    var dateText: EditText? = null
    public var p: Int? = 0
    public var o: Int? = 0
    public var w: Int? = 0

    //Entry Table
    public var entryCounter: Int? = 1
    var ent1: String? = null
    var ent2: String? = null
    var ent3: String? = null
    var ent4: String? = null
    var ent5: String? = null
    var ent6: String? = null

    public var cat1: String? = null
    var cat2: String? = null
    var cat3: String? = null
    var cat4: String? = null
    var cat5: String? = null
    var cat6: String? = null

    public var dat1: String? = null
    var dat2: String? = null
    var dat3: String? = null
    var dat4: String? = null
    var dat5: String? = null
    var dat6: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timesheet)
        dialog = Dialog(this@TimesheeyEntry)
        dialog!!.setContentView(R.layout.popup_window);
        dialog!!.window!!.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog2 = Dialog(this@TimesheeyEntry)
        dialog2!!.setContentView(R.layout.total_categories);

        viewCat = findViewById(R.id.viewCatergory)
        viewEnt = findViewById(R.id.viewEntries)
        tBack = findViewById(R.id.back_btn)
        editText= dialog!!.findViewById(R.id.po);
        add_subject= dialog!!.findViewById(R.id.add_subject);
        delete_subject= dialog!!.findViewById(R.id.delete_subject);
        photoImageView = dialog!!.findViewById(R.id.photoImageView)
        addPhotoButton = dialog!!.findViewById(R.id.addPhotoButton)
        categoryText = dialog!!.findViewById(R.id.categorie)
        dateText = dialog!!.findViewById(R.id.date)


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
        Sun1.setOnClickListener(View.OnClickListener { show(Sun1, "Sunday1", categoryText ,dateText) })
        Sun2.setOnClickListener(View.OnClickListener { show(Sun2, "Sunday2", categoryText!!,dateText) })
        Sun3.setOnClickListener(View.OnClickListener { show(Sun3, "Sunday3",categoryText!!,dateText) })
        Sun4.setOnClickListener(View.OnClickListener { show(Sun4, "Sunday4",categoryText!!,dateText) })
        Sun5.setOnClickListener(View.OnClickListener { show(Sun5, "Sunday5",categoryText!!,dateText) })
        Sun6.setOnClickListener(View.OnClickListener { show(Sun6, "Sunday6",categoryText!!,dateText) })
        Sun7.setOnClickListener(View.OnClickListener { show(Sun7, "Sunday7",categoryText!!,dateText) })
        Sun8.setOnClickListener(View.OnClickListener { show(Sun8, "Sunday8",categoryText!!,dateText) })
        Sun9.setOnClickListener(View.OnClickListener { show(Sun9, "Sunday9",categoryText!!,dateText) })

        Mon1.setOnClickListener(View.OnClickListener { show(Mon1, "Monday1",categoryText!!,dateText) })
        Mon2.setOnClickListener(View.OnClickListener { show(Mon2, "Monday2",categoryText!!,dateText) })
        Mon3.setOnClickListener(View.OnClickListener { show(Mon3, "Monday3",categoryText!!,dateText) })
        Mon4.setOnClickListener(View.OnClickListener { show(Mon4, "Monday4",categoryText!!,dateText) })
        Mon5.setOnClickListener(View.OnClickListener { show(Mon5, "Monday5",categoryText!!,dateText) })
        Mon6.setOnClickListener(View.OnClickListener { show(Mon6, "Monday6",categoryText!!,dateText) })
        Mon7.setOnClickListener(View.OnClickListener { show(Mon7, "Monday7",categoryText!!,dateText) })
        Mon8.setOnClickListener(View.OnClickListener { show(Mon8, "Monday8",categoryText!!,dateText) })
        Mon9.setOnClickListener(View.OnClickListener { show(Mon9, "Monday9",categoryText!!,dateText) })


        Tue1.setOnClickListener(View.OnClickListener { show(Tue1, "Tuesday1",categoryText!!,dateText) })
        Tue2.setOnClickListener(View.OnClickListener { show(Tue2, "Tuesday2",categoryText!!,dateText) })
        Tue3.setOnClickListener(View.OnClickListener { show(Tue3, "Tuesday3",categoryText!!,dateText) })
        Tue4.setOnClickListener(View.OnClickListener { show(Tue4, "Tuesday4",categoryText!!,dateText) })
        Tue5.setOnClickListener(View.OnClickListener { show(Tue5, "Tuesday5",categoryText!!,dateText) })
        Tue6.setOnClickListener(View.OnClickListener { show(Tue6, "Tuesday6",categoryText!!,dateText) })
        Tue7.setOnClickListener(View.OnClickListener { show(Tue7, "Tuesday7",categoryText!!,dateText) })
        Tue8.setOnClickListener(View.OnClickListener { show(Tue8, "Tuesday8",categoryText!!,dateText) })
        Tue9.setOnClickListener(View.OnClickListener { show(Tue9, "Tuesday9",categoryText!!,dateText) })


        Wed1.setOnClickListener(View.OnClickListener { show(Wed1, "Wednesday1",categoryText!!,dateText) })
        Wed2.setOnClickListener(View.OnClickListener { show(Wed2, "Wednesday2",categoryText!!,dateText) })
        Wed3.setOnClickListener(View.OnClickListener { show(Wed3, "Wednesday3",categoryText!!,dateText) })
        Wed4.setOnClickListener(View.OnClickListener { show(Wed4, "Wednesday4",categoryText!!,dateText) })
        Wed5.setOnClickListener(View.OnClickListener { show(Wed5, "Wednesday5",categoryText!!,dateText) })
        Wed6.setOnClickListener(View.OnClickListener { show(Wed6, "Wednesday6",categoryText!!,dateText) })
        Wed7.setOnClickListener(View.OnClickListener { show(Wed7, "Wednesday7",categoryText!!,dateText) })
        Wed8.setOnClickListener(View.OnClickListener { show(Wed8, "Wednesday8",categoryText!!,dateText) })
        Wed9.setOnClickListener(View.OnClickListener { show(Wed9, "Wednesday9",categoryText!!,dateText) })


        Thu1.setOnClickListener(View.OnClickListener { show(Thu1, "Thursday1",categoryText!!,dateText) })
        Thu2.setOnClickListener(View.OnClickListener { show(Thu2, "Thursday2",categoryText!!,dateText) })
        Thu3.setOnClickListener(View.OnClickListener { show(Thu3, "Thursday3",categoryText!!,dateText) })
        Thu4.setOnClickListener(View.OnClickListener { show(Thu4, "Thursday4",categoryText!!,dateText) })
        Thu5.setOnClickListener(View.OnClickListener { show(Thu5, "Thursday5",categoryText!!,dateText) })
        Thu6.setOnClickListener(View.OnClickListener { show(Thu6, "Thursday6",categoryText!!,dateText) })
        Thu7.setOnClickListener(View.OnClickListener { show(Thu7, "Thursday7",categoryText!!,dateText) })
        Thu8.setOnClickListener(View.OnClickListener { show(Thu8, "Thursday8",categoryText!!,dateText) })
        Thu9.setOnClickListener(View.OnClickListener { show(Thu9, "Thursday9",categoryText!!,dateText) })


        Fri1.setOnClickListener(View.OnClickListener { show(Fri1, "Friday1",categoryText!!,dateText) })
        Fri2.setOnClickListener(View.OnClickListener { show(Fri2, "Friday2",categoryText!!,dateText) })
        Fri3.setOnClickListener(View.OnClickListener { show(Fri3, "Friday3",categoryText!!,dateText) })
        Fri4.setOnClickListener(View.OnClickListener { show(Fri4, "Friday4",categoryText!!,dateText) })
        Fri5.setOnClickListener(View.OnClickListener { show(Fri5, "Friday5",categoryText!!,dateText) })
        Fri6.setOnClickListener(View.OnClickListener { show(Fri6, "Friday6",categoryText!!,dateText) })
        Fri7.setOnClickListener(View.OnClickListener { show(Fri7, "Friday7",categoryText!!,dateText) })
        Fri8.setOnClickListener(View.OnClickListener { show(Fri8, "Friday8",categoryText!!,dateText) })
        Fri9.setOnClickListener(View.OnClickListener { show(Fri9, "Friday9",categoryText!!,dateText) })


        Sat1.setOnClickListener(View.OnClickListener { show(Sat1, "Saturday1",categoryText!!,dateText) })
        Sat2.setOnClickListener(View.OnClickListener { show(Sat2, "Saturday2",categoryText!!,dateText) })
        Sat3.setOnClickListener(View.OnClickListener { show(Sat3, "Saturday3",categoryText!!,dateText) })
        Sat4.setOnClickListener(View.OnClickListener { show(Sat4, "Saturday4",categoryText!!,dateText) })
        Sat5.setOnClickListener(View.OnClickListener { show(Sat5, "Saturday5",categoryText!!,dateText) })
        Sat6.setOnClickListener(View.OnClickListener { show(Sat6, "Saturday6",categoryText!!,dateText) })
        Sat7.setOnClickListener(View.OnClickListener { show(Sat7, "Saturday7",categoryText!!,dateText) })
        Sat8.setOnClickListener(View.OnClickListener { show(Sat8, "Saturday8",categoryText!!,dateText) })
        Sat9.setOnClickListener(View.OnClickListener { show(Sat9, "Saturday9",categoryText!!,dateText) })


        viewCat!!.setOnClickListener({
            //setContentView(R.layout)
            val intent = Intent(this,CategoryHours::class.java)
            intent.putExtra("personalTime", p)
            intent.putExtra("workTime", w)
            intent.putExtra("overTime", o)
            startActivity(intent)
        })
        viewEnt!!.setOnClickListener({
            //setContentView(R.layout)
            val intent = Intent(this,EntryTable::class.java)
            intent.putExtra("e1", ent1)
            intent.putExtra("d1", dat1)
            intent.putExtra("c1", cat1)
            intent.putExtra("e2", ent2)
            intent.putExtra("d2", dat2)
            intent.putExtra("c2", cat2)

            intent.putExtra("e3", ent3)
            intent.putExtra("d3", dat3)
            intent.putExtra("c3", cat3)

            intent.putExtra("e4", ent4)
            intent.putExtra("d4", dat4)
            intent.putExtra("c4", cat4)

            intent.putExtra("e5", ent5)
            intent.putExtra("d5", dat5)
            intent.putExtra("c5", cat5)

            intent.putExtra("e6", ent6)
            intent.putExtra("d6", dat6)
            intent.putExtra("c6", cat6)
            startActivity(intent)
        })
        tBack!!.setOnClickListener({
            //setContentView(R.layout)
            val intent = Intent(this,SelectPage::class.java)
            startActivity(intent)
        })
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

    fun show(textView: TextView?, dayname: String?, catView: EditText?, datView: EditText?) {
        timetable_subject = null
        dialog!!.show()
        var e: String
        var c: String
        var d: String
        add_subject!!.setOnClickListener {
            timetable_subject = editText!!.text.toString()
            e = editText!!.text.toString()
            c = catView!!.text.toString()
            d = datView!!.text.toString()
            if (timetable_subject!!.isEmpty()) {
                editText!!.requestFocus()
                editText!!.error = "field is empty"
            } else {
                //HashMap<String, Object> values = new HashMap<>();
                //values.put(dayname, timetable_subject);
                //databaseStudents.child(user.getUid()).updateChildren(values);
                textView!!.text = timetable_subject

                //catView!!.text = cTxt
                if (catView!!.text.toString() == "personal")
                {
                    p = p!! + 1
                }
                if (catView!!.text.toString() == "work")
                {
                    w = w!! + 1
                }
                if (catView!!.text.toString() == "overtime")
                {
                    o = o!! + 1
                }
                if (entryCounter == 1)
                {
                    ent1 = textView!!.text.toString()
                    cat1= catView!!.text.toString()
                    dat1= datView!!.text.toString()
                    //entryCounter = entryCounter!! + 1
                }
                if (entryCounter == 2)
                {
                    ent2 = textView!!.text.toString()
                    cat2 = catView!!.text.toString()
                    dat2 = datView!!.text.toString()
                }
                if (entryCounter == 3)
                {
                    ent3 = textView!!.text.toString()
                    cat3= catView!!.text.toString()
                    dat3= datView!!.text.toString()
                }
                if (entryCounter == 4)
                {
                    ent4 = textView!!.text.toString()
                    cat4= catView!!.text.toString()
                    dat4= datView!!.text.toString()
                }
                if (entryCounter == 5)
                {
                    ent5 = textView!!.text.toString()
                    cat5= catView!!.text.toString()
                    dat5= datView!!.text.toString()
                }
                if (entryCounter == 6)
                {
                    ent6 = textView!!.text.toString()
                    cat6= catView!!.text.toString()
                    dat6 = datView!!.text.toString()
                }
                entryCounter = entryCounter!! + 1
                if (entryCounter == 7)
                {
                    entryCounter = 0
                }
                editText!!.setText("")
                dialog!!.dismiss()
            }
        }
        delete_subject!!.setOnClickListener { //databaseStudents.child(user.getUid()).child(dayname).removeValue();
            textView!!.text = ""
            dialog!!.dismiss()
        }
    }

    /*fun personalCat(textView: TextView?)
    {
        textView!!.text = (personalTime?.times(0.5f)).toString()
    }*/
}