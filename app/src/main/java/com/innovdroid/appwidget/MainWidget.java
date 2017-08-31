package com.innovdroid.appwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {


        for (int i=0;i<appWidgetIds.length;i++)
        {
            int awidgetId=appWidgetIds[i];

            RemoteViews views=new RemoteViews(context.getPackageName(),R.layout.activity_main_widget);
            SimpleDateFormat smf=new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");

            String currentDateAndTime=smf.format(new Date());
            views.setTextViewText(R.id.editText,currentDateAndTime);

            Intent intent=new Intent(context,MainActivity.class);


            PendingIntent pendingIntent=PendingIntent.getActivity(context,0,intent,0);
            views.setOnClickPendingIntent(R.id.button,pendingIntent);

            // notify appwidgetManager to update widgets
            appWidgetManager.updateAppWidget(awidgetId,views);


        }
    }



}
