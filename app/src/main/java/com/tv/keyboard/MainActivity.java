package com.tv.keyboard;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
public class MainActivity extends Activity {
protected void onCreate(Bundle b){super.onCreate(b);LinearLayout l=new LinearLayout(this);l.setOrientation(1);l.setPadding(50,100,50,50);TextView t=new TextView(this);t.setText("Auto2Digit TV Keyboard\n01=A 02=B ... 26=Z\n00=SPACE 27=DEL\n08 05 12 12 15 = HELLO\n1. ENABLE 2. SET DEFAULT");t.setTextSize(18);Button b1=new Button(this);b1.setText("ENABLE KEYBOARD");b1.setOnClickListener(v->startActivity(new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS)));Button b2=new Button(this);b2.setText("SET AS DEFAULT");b2.setOnClickListener(v->((android.view.inputmethod.InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).showInputMethodPicker());l.addView(t);l.addView(b1);l.addView(b2);setContentView(l);}
}
