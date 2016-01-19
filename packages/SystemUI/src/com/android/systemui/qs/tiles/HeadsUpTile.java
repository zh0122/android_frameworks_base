/*
 * Copyright (C) 2015 The CyanogenMod Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.systemui.qs.tiles;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.provider.Settings.Global;

<<<<<<< HEAD
=======
import com.android.internal.logging.MetricsLogger;
>>>>>>> ResurrectionRemix/marshmallow
import com.android.systemui.qs.GlobalSetting;
import com.android.systemui.qs.QSTile;
import com.android.systemui.R;

<<<<<<< HEAD
import org.cyanogenmod.internal.logging.CMMetricsLogger;

/** Quick settings tile: Heads up **/
public class HeadsUpTile extends QSTile<QSTile.BooleanState> {

    private static final Intent NOTIFICATION_SETTINGS =
            new Intent("android.settings.NOTIFICATION_MANAGER");
=======
/** Quick settings tile: Heads up **/
public class HeadsUpTile extends QSTile<QSTile.BooleanState> {

    //private static final Intent NOTIFICATION_SETTINGS = new Intent("android.settings.NOTIFICATION_MANAGER");
>>>>>>> ResurrectionRemix/marshmallow

    private final GlobalSetting mSetting;

    public HeadsUpTile(Host host) {
        super(host);

        mSetting = new GlobalSetting(mContext, mHandler, Global.HEADS_UP_NOTIFICATIONS_ENABLED) {
            @Override
            protected void handleValueChanged(int value) {
                handleRefreshState(value);
            }
        };
    }

    @Override
    protected BooleanState newTileState() {
        return new BooleanState();
    }

    @Override
    protected void handleClick() {
<<<<<<< HEAD
=======
        MetricsLogger.action(mContext, getMetricsCategory());
>>>>>>> ResurrectionRemix/marshmallow
        setEnabled(!mState.value);
        refreshState();
    }

    @Override
    protected void handleLongClick() {
<<<<<<< HEAD
        mHost.startActivityDismissingKeyguard(NOTIFICATION_SETTINGS);
=======
        //mHost.startActivityDismissingKeyguard(NOTIFICATION_SETTINGS);
>>>>>>> ResurrectionRemix/marshmallow
    }

    private void setEnabled(boolean enabled) {
        Settings.Global.putInt(mContext.getContentResolver(),
                Settings.Global.HEADS_UP_NOTIFICATIONS_ENABLED,
                enabled ? 1 : 0);
    }

    @Override
<<<<<<< HEAD
=======
    public int getMetricsCategory() {
        return MetricsLogger.QS_HEADSUP;
    }

    @Override
>>>>>>> ResurrectionRemix/marshmallow
    protected void handleUpdateState(BooleanState state, Object arg) {
        final int value = arg instanceof Integer ? (Integer)arg : mSetting.getValue();
        final boolean headsUp = value != 0;
        state.value = headsUp;
        state.visible = true;
        state.label = mContext.getString(R.string.quick_settings_heads_up_label);
        if (headsUp) {
            state.icon = ResourceIcon.get(R.drawable.ic_qs_heads_up_on);
            state.contentDescription =  mContext.getString(
                    R.string.accessibility_quick_settings_heads_up_on);
        } else {
            state.icon = ResourceIcon.get(R.drawable.ic_qs_heads_up_off);
            state.contentDescription =  mContext.getString(
                    R.string.accessibility_quick_settings_heads_up_off);
        }
    }

    @Override
    protected String composeChangeAnnouncement() {
        if (mState.value) {
            return mContext.getString(R.string.accessibility_quick_settings_heads_up_changed_on);
        } else {
            return mContext.getString(R.string.accessibility_quick_settings_heads_up_changed_off);
        }
    }

    @Override
<<<<<<< HEAD
    public int getMetricsCategory() {
        return CMMetricsLogger.TILE_HEADS_UP;
    }

    @Override
=======
>>>>>>> ResurrectionRemix/marshmallow
    public void setListening(boolean listening) {
        // Do nothing
    }
}
