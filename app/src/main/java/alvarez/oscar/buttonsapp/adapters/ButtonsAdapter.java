package alvarez.oscar.buttonsapp.adapters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import alvarez.oscar.buttonsapp.ButtonsApplication;
import alvarez.oscar.buttonsapp.R;
import alvarez.oscar.buttonsapp.databinding.AppleButtonLayoutBinding;
import alvarez.oscar.buttonsapp.databinding.GoogleButtonLayoutBinding;
import alvarez.oscar.buttonsapp.databinding.YahooButtonLayoutBinding;
import alvarez.oscar.buttonsapp.models.ButtonObject;

/**
 * Created by Oscar Álvarez on 01/09/18.
 */
public class ButtonsAdapter extends RecyclerView.Adapter<ButtonsAdapter.ButtonViewHolder> {
    private List<ButtonObject> buttonObjects;

    public ButtonsAdapter(List<ButtonObject> buttonsList) {
        buttonObjects = buttonsList;
    }

    @NonNull
    @Override
    public ButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case ButtonObject.APPLE_TYPE:
                view = AppleButtonLayoutBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                ).getRoot();
                break;
            case ButtonObject.YAHOO_TYPE:
                view = YahooButtonLayoutBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                ).getRoot();
                break;
            case ButtonObject.GOOGLE_TYPE:
                view = GoogleButtonLayoutBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                ).getRoot();
                break;
            default:
                view = null;
        }
        return new ButtonViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        return buttonObjects.get(position).type;
    }

    @Override
    public void onBindViewHolder(@NonNull ButtonViewHolder holder, int position) {
        holder.bind(buttonObjects.get(position));
    }

    @Override
    public int getItemCount() {
        return buttonObjects.size();
    }

    class ButtonViewHolder extends RecyclerView.ViewHolder {

        View view;

        public ButtonViewHolder(@Nullable View itemView) {
            super(itemView);
            view = itemView;
        }

        public void bind(ButtonObject buttonObject) {
            view.findViewById(R.id.button)
                    .setOnClickListener(v -> Toast.makeText(ButtonsApplication.getInstance(),
                            getToastText(buttonObject.type), Toast.LENGTH_SHORT).show());
            if (buttonObject.text != null) {
                ((TextView) view.findViewById(R.id.button_text)).setText(buttonObject.text);
            }
        }

        @StringRes
        private int getToastText(int type) {
            switch (type) {
                case ButtonObject.APPLE_TYPE:
                    return R.string.apple_button_toast;
                case ButtonObject.GOOGLE_TYPE:
                    return R.string.google_button_toast;
                case ButtonObject.YAHOO_TYPE:
                    return R.string.yahoo_button_toast;
                default:
                    return R.string.apple_button_toast;
            }
        }
    }
}
