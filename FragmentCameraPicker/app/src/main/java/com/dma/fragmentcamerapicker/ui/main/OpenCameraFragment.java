package com.dma.fragmentcamerapicker.ui.main;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.dma.fragmentcamerapicker.R;

import dev.ronnie.github.imagepicker.ImagePicker;
import dev.ronnie.github.imagepicker.ImageResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class OpenCameraFragment extends Fragment {

    private Button message;
    private ImageView imageView;
    private ImagePicker imagePicker;

    public static OpenCameraFragment newInstance() {
        return new OpenCameraFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        imagePicker = new ImagePicker(this);
        message = root.findViewById(R.id.message);
        imageView = root.findViewById(R.id.imageView);

        message.setOnClickListener(v -> imagePicker.takeFromCamera(imageCallBack()));

        return root;
    }

    //CallBack for result
    private Function1<ImageResult<? extends Uri>, Unit> imageCallBack() {
        return imageResult -> {
            if (imageResult instanceof ImageResult.Success) {
                Uri uri = ((ImageResult.Success<Uri>) imageResult).getValue();
                imageView.setImageURI(uri);
            } else {
                String errorString = ((ImageResult.Failure) imageResult).getErrorString();
                Toast.makeText(getContext(), errorString, Toast.LENGTH_LONG).show();
            }
            return null;
        };
    }

}