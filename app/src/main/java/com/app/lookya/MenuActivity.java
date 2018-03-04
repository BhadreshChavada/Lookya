package com.app.lookya;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zappar.ZapparEmbed;

/**
 * Created by Bhadresh Chavada on 02-03-2018.
 */

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_menu);

        Intent i = new Intent(MenuActivity.this, ZapparEmbed.getZapcodeClassForIntent());
        startActivity(i);

    }

    public void menuSelect(View view) {
        if (view.getId() == R.id.share_app) {
            final String appPackageName = getPackageName();
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Check out " + getString(R.string.app_name) + " App on PlayStore: https://play.google.com/store/apps/details?id=" + appPackageName);
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        } else if (view.getId() == R.id.txt_open_scanner) {
            Intent i = new Intent(MenuActivity.this, ZapparEmbed.getZapcodeClassForIntent());
            startActivity(i);
        } else if (view.getId() == R.id.contacus) {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", "info@netgeekzcayman.com", null));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Look Ya - App Support");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "");
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        } else if (view.getId() == R.id.how_to_use) {
            Intent i = new Intent(MenuActivity.this, HowtoUseActivity.class);
            startActivity(i);
        }

//        else if (view.getId() == R.id.contacus) {
//            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
//                    "mailto","abc@gmail.com", null));
//            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
//            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
//            startActivity(Intent.createChooser(emailIntent, "Send email..."));
//        } else if (view.getId() == R.id.feedback) {
//            Uri uri = Uri.parse("market://details?id=" + getPackageName());
//            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
//            // To count with Play market backstack, After pressing back button,
//            // to taken back to our application, we need to add following flags to intent.
//            goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
//                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
//                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
//            try {
//                startActivity(goToMarket);
//            } catch (ActivityNotFoundException e) {
//                startActivity(new Intent(Intent.ACTION_VIEW,
//                        Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
//            }
//        }
    }

}
