package udaan.beone.mrpoint.activity.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import udaan.beone.mrpoint.R;
import udaan.beone.mrpoint.data.DataManager;
import udaan.beone.mrpoint.http.model.MrVisit;
import udaan.beone.mrpoint.http.util.HTTPConst;
import udaan.beone.mrpoint.http.util.HTTPTask;

/**
 * Created by Vaibhav on 23-05-2016.
 */
public class OkDialog extends Dialog implements View.OnClickListener {

    protected Activity context;

    public OkDialog(Activity context, String title, String message) {

        super(context);
        this.context = context;

        // custom dialog
        setContentView(R.layout.dialog_ok);
        setTitle(title);

        TextView text = (TextView) findViewById(R.id.d_message);
        text.setText(message);

        Button button = (Button) findViewById(R.id.d_button);
        button.setText("Ok");
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.d_button:
                this.dismiss();
                break;
        }
    }
}
