package in.vibescom.groceryapp.UI.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import in.vibescom.groceryapp.R;

@SuppressLint("ValidFragment")
public class ImageFragment extends Fragment {
    int imageResource;

    public ImageFragment(int imageResource) {
        this.imageResource = imageResource;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_viewpager_image, container, false);
        ImageView img = rootView.findViewById(R.id.iv_feed_banner);
        img.setImageResource(imageResource);
        return rootView;
    }
}
