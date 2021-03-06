/*
 * Copyright (C) 2013 Peng fei Pan <sky@xiaopan.me>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.xiaopan.spear;

import android.widget.ImageView;

import me.xiaopan.spear.display.ImageDisplayer;
import me.xiaopan.spear.process.ImageProcessor;

public class DisplayParams {
    // 基本属性
    public String uri;
    public String name;

    // 下载属性
    public boolean enableDiskCache = true;
    public ProgressListener progressListener;

    // 加载属性
    public RequestHandleLevel requestHandleLevel = RequestHandleLevel.NET;
    public ImageSize maxsize;
    public ImageSize resize;
    public ImageProcessor imageProcessor;
    public ImageView.ScaleType scaleType;

    // 显示属性
    public String memoryCacheId;
    public boolean enableMemoryCache = true;
    public boolean thisIsGifImage;
    public ImageDisplayer imageDisplayer;
    public DrawableHolder loadingDrawableHolder;
    public DrawableHolder loadFailDrawableHolder;
    public DrawableHolder pauseDownloadDrawableHolder;
    public DisplayListener displayListener;
}
