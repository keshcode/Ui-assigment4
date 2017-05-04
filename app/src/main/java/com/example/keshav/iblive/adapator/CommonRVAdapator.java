package com.example.keshav.iblive.adapator;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;

import com.example.keshav.iblive.R;
import com.example.keshav.iblive.constant.Constants;

/**
 * This is a common recycler view to be used every by passing mode
 */

public class CommonRVAdapator extends RecyclerView.Adapter<CommonRVAdapator.ViewHolder> implements Constants {
    private int mMode;

    /**
     * @param mode mode of adaptor to be used
     */
    public CommonRVAdapator(final int mode) {
        this.mMode = mode;
    }

    @Override
    public CommonRVAdapator.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        if (mMode == MODE_DISCOVER || mMode == MODE_MYPOST) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_discover_mypost, parent, false);
            return new ViewHolder(view);
        } else if (mMode == MODE_MYNETWORK) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_mynetwork, parent, false);
            return new ViewHolder(view);
        }
        else if(mMode == MODE_NEW_REQUEST){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_new_request,parent,false);
            return new ViewHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_discover_mypost, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final CommonRVAdapator.ViewHolder holder, final int position) {
        // rescently all the data is static
    }

    @Override
    public int getItemCount() {
        //keeping the recycler view count static
        return 10;
    }

    /**
     * inner viewHolder class contians the view to be inflated
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCardHeading, tvCardLocation, tvCardDel, tvCardEdit, tvSendRequest, tvTravler, tvduration, tvComment, tvCardContant;
        RatingBar rbCard;
        Switch swCardSwitch;
        ImageView ivDiscover, ivAddImage;

        /**
         * @param itemView reference of the view to be inflated
         */
        public ViewHolder(final View itemView) {
            super(itemView);
            tvCardHeading = (TextView) itemView.findViewById(R.id.tvCardHeading);
            tvCardLocation = (TextView) itemView.findViewById(R.id.tvCardLocation);
            tvCardDel = (TextView) itemView.findViewById(R.id.tvCardDel);
            tvCardEdit = (TextView) itemView.findViewById(R.id.tvCardEdit);
            tvSendRequest = (TextView) itemView.findViewById(R.id.tvSendRequest);
            tvTravler = (TextView) itemView.findViewById(R.id.tvTravler);
            tvduration = (TextView) itemView.findViewById(R.id.tvduration);
            tvComment = (TextView) itemView.findViewById(R.id.tvComment);
            tvCardContant = (TextView) itemView.findViewById(R.id.tvCardContant);
            rbCard = (RatingBar) itemView.findViewById(R.id.rbCard);
            swCardSwitch = (Switch) itemView.findViewById(R.id.swCardSwitch);
            ivDiscover = (ImageView) itemView.findViewById(R.id.ivDiscover);
            ivAddImage = (ImageView) itemView.findViewById(R.id.ivAddImage);

            if (mMode == MODE_DISCOVER) {
                tvCardDel.setVisibility(View.GONE);
                tvCardEdit.setVisibility(View.GONE);
                swCardSwitch.setVisibility(View.GONE);

            } else if (mMode == MODE_MYPOST) {
                tvCardDel.setVisibility(View.VISIBLE);
                tvCardEdit.setVisibility(View.VISIBLE);
                swCardSwitch.setVisibility(View.VISIBLE);
                tvCardLocation.setVisibility(View.GONE);
                tvSendRequest.setVisibility(View.GONE);
                tvTravler.setVisibility(View.GONE);
                ivAddImage.setVisibility(View.GONE);
                rbCard.setVisibility(View.GONE);
            }
        }
    }
}