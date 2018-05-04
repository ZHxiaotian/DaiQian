package com.zonesun.daiqian.util;

import com.zonesun.daiqian.activity.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 
 */
public class CirclePercentView extends View {

	private float mRadius;

	private float mStripeWidth;

	private int mHeight;
	private int mWidth;

	private int mCurPercent;

	private int mPercent;

	private float x;
	private float y;

	private int mEndAngle;

	private int mSmallColor;

	private int mBigColor;

	private float mCenterTextSize;

	public CirclePercentView(Context context) {
		this(context, null);
	}

	public CirclePercentView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public CirclePercentView(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		TypedArray a = context.obtainStyledAttributes(attrs,
				R.styleable.CirclePercentView, defStyleAttr, 0);
		mStripeWidth = a.getDimension(
				R.styleable.CirclePercentView_stripeWidth,
				ScreenUtils.dpToPx(15, context));
		mCurPercent = a.getInteger(R.styleable.CirclePercentView_percent, 0);
		mSmallColor = a.getColor(R.styleable.CirclePercentView_smallColor,
				0xffafb4db);
		mBigColor = a.getColor(R.styleable.CirclePercentView_bigColor,
				0xff6950a1);
		mCenterTextSize = a.getDimensionPixelSize(
				R.styleable.CirclePercentView_centerTextSize,
				ScreenUtils.spToPx(5, context));
		mRadius = a.getDimensionPixelSize(R.styleable.CirclePercentView_radius,
				ScreenUtils.dpToPx(50, context));

	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
		int heightMode = MeasureSpec.getMode(heightMeasureSpec);

		int widthSize = MeasureSpec.getSize(widthMeasureSpec);
		int heightSize = MeasureSpec.getSize(heightMeasureSpec);

		if (widthMode == MeasureSpec.EXACTLY
				&& heightMode == MeasureSpec.EXACTLY) {
			mRadius = widthSize / 2;
			x = widthSize / 2;
			y = heightSize / 2;
			mWidth = widthSize;
			mHeight = heightSize;
		}

		if (widthMode == MeasureSpec.AT_MOST
				&& heightMode == MeasureSpec.AT_MOST) {
			mWidth = (int) (mRadius * 2);
			mHeight = (int) (mRadius * 2);
			x = mRadius;
			y = mRadius;

		}

		setMeasuredDimension(mWidth, mHeight);
	}

	@Override
	protected void onDraw(Canvas canvas) {

		mEndAngle = (int) (mCurPercent * 3.6);

		Paint bigCirclePaint = new Paint();
		bigCirclePaint.setAntiAlias(true);
		bigCirclePaint.setColor(mBigColor);

		canvas.drawCircle(x, y, mRadius, bigCirclePaint);

		Paint sectorPaint = new Paint();
		sectorPaint.setColor(mSmallColor);
		sectorPaint.setAntiAlias(true);
		RectF rect = new RectF(0, 0, mWidth, mHeight);

		canvas.drawArc(rect, 270, mEndAngle, true, sectorPaint);

		Paint smallCirclePaint = new Paint();
		smallCirclePaint.setAntiAlias(true);
		smallCirclePaint.setColor(mBigColor);
		canvas.drawCircle(x, y, mRadius - mStripeWidth, smallCirclePaint);

		Paint textPaint = new Paint();
		String text = mCurPercent + "";

		textPaint.setTextSize(mCenterTextSize);
		float textLength = textPaint.measureText(text);

		textPaint.setColor(Color.WHITE);
		canvas.drawText(text, x - textLength / 2, y, textPaint);

	}

	public void setPercent(int percent) {
		if (percent > 100) {
			throw new IllegalArgumentException("percent must less than 100!");
		}

		setCurPercent(percent);

	}

	private void setCurPercent(final int percent) {

		mPercent = percent;

		new Thread(new Runnable() {
			@Override
			public void run() {

				mCurPercent = percent;
				CirclePercentView.this.postInvalidate();

			}

		}).start();

	}

}
