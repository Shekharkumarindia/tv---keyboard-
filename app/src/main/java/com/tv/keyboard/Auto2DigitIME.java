package com.tv.keyboard;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.view.KeyEvent;
public class Auto2DigitIME extends InputMethodService implements KeyboardView.OnKeyboardActionListener {
private StringBuilder buffer=new StringBuilder();
String mapCode(String c){if(c.equals("00"))return " ";if(c.equals("27"))return "DEL";if(c.equals("28"))return "ENTER";try{int n=Integer.parseInt(c);if(n>=1&&n<=26)return String.valueOf((char)(64+n));}catch(Exception e){}return null;}
public View onCreateInputView(){KeyboardView kv=(KeyboardView)getLayoutInflater().inflate(R.layout.keyboard_view,null);kv.setKeyboard(new Keyboard(this,R.xml.keys));kv.setOnKeyboardActionListener(this);kv.setPreviewEnabled(false);return kv;}
public void onKey(int code,int[] k){InputConnection ic=getCurrentInputConnection();if(ic==null)return;if(code>=1000&&code<=1009){buffer.append(code-1000);if(buffer.length()==2){String r=mapCode(buffer.toString());buffer.setLength(0);if(r!=null){if(r.equals("DEL"))ic.deleteSurroundingText(1,0);else if(r.equals("ENTER"))ic.sendKeyEvent(new KeyEvent(0,4));else ic.commitText(r,1);}}}else if(code==-5){ic.deleteSurroundingText(1,0);buffer.setLength(0);}else if(code==-4){ic.sendKeyEvent(new KeyEvent(0,4));}}
public void onPress(int i){} public void onRelease(int i){} public void onText(CharSequence c){} public void swipeLeft(){} public void swipeRight(){} public void swipeDown(){} public void swipeUp(){}
}
