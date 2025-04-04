// Generated by view binder compiler. Do not edit!
package ru.myitschool.mte.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ru.myitschool.mte.R;

public final class ContentMainBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final FrameLayout outputFragment;

  @NonNull
  public final Button startBtn;

  @NonNull
  public final Button stopBtn;

  private ContentMainBinding(@NonNull LinearLayout rootView, @NonNull FrameLayout outputFragment,
      @NonNull Button startBtn, @NonNull Button stopBtn) {
    this.rootView = rootView;
    this.outputFragment = outputFragment;
    this.startBtn = startBtn;
    this.stopBtn = stopBtn;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ContentMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ContentMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.content_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ContentMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.output_fragment;
      FrameLayout outputFragment = ViewBindings.findChildViewById(rootView, id);
      if (outputFragment == null) {
        break missingId;
      }

      id = R.id.start_btn;
      Button startBtn = ViewBindings.findChildViewById(rootView, id);
      if (startBtn == null) {
        break missingId;
      }

      id = R.id.stop_btn;
      Button stopBtn = ViewBindings.findChildViewById(rootView, id);
      if (stopBtn == null) {
        break missingId;
      }

      return new ContentMainBinding((LinearLayout) rootView, outputFragment, startBtn, stopBtn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
