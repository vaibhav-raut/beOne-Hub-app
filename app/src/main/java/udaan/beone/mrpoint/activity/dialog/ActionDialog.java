package udaan.beone.mrpoint.activity.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import udaan.beone.mrpoint.R;

/**
 * Created by Vaibhav on 23-05-2016.
 */
public abstract class ActionDialog extends Dialog implements View.OnClickListener {

    protected Activity context;

    public ActionDialog(Activity context, String title, String message, String button1Name, String button2Name) {

        super(context);
        this.context = context;

        // custom dialog
        setContentView(R.layout.dialog_action);
        setTitle(title);

        TextView text = (TextView) findViewById(R.id.ac_message);
        text.setText(message);

//        ImageView image = (ImageView) findViewById(R.id.image);
//        image.setImageResource(R.drawable.ic_launcher);

        Button button1 = (Button) findViewById(R.id.ac_button_1);
        button1.setText(button1Name);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.ac_button_2);
        button2.setText(button2Name);
        button2.setOnClickListener(this);
    }
}
