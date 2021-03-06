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

/**
 * DisplayHelper
 */
public interface DisplayHelper {

    /**
     * 初始化
     */
    DisplayHelper init(Spear spear, String uri, ImageView imageView);

    /**
     * 初始化
     */
    DisplayHelper init(Spear spear, DisplayParams displayParams, ImageView imageView);

    /**
     * 恢复默认值
     */
    void reset();

    /**
     * 填充
     */
    void fullDisplayParams();

    /**
     * 设置名称，用于在log总区分请求
     * @param name 名称
     * @return DisplayHelper
     */
    DisplayHelper name(String name);

    /**
     * 设置内存缓存ID（大多数情况下你不需要手动设置缓存ID，除非你想使用通过putBitmap()放到缓存中的图片）
     * @param memoryCacheId 内存缓存ID
     * @return DisplayHelper
     */
    DisplayHelper memoryCacheId(String memoryCacheId);

    /**
     * 关闭硬盘缓存
     * @return DisplayHelper
     */
    DisplayHelper disableDiskCache();

    /**
     * 设置最大尺寸，在解码时会使用此Size来计算inSimpleSize
     * @param maxsize 最大尺寸
     * @return DisplayHelper
     */
    DisplayHelper maxsize(ImageSize maxsize);

    /**
     * 设置最大尺寸，在解码时会使用此Size来计算inSimpleSize
     * @param width 宽
     * @param height 高
     * @return DisplayHelper
     */
    DisplayHelper maxsize(int width, int height);

    /**
     * 裁剪图片，ImageProcessor会根据此宽高和ScaleType裁剪图片
     * @param resize 新的尺寸
     * @return DisplayHelper
     */
    DisplayHelper resize(ImageSize resize);

    /**
     * 裁剪图片，ImageProcessor会根据此宽高和ScaleType裁剪图片
     * @param width 宽
     * @param height 高
     * @return DisplayHelper
     */
    DisplayHelper resize(int width, int height);

    /**
     * 根据ImageView的LayoutSize裁剪图片
     */
    DisplayHelper resizeByImageViewLayoutSize();

    /**
     * 设置图片处理器，图片处理器会根据resize和ScaleType创建一张新的图片
     * @param processor Bitmap处理器
     * @return DisplayHelper
     */
    DisplayHelper processor(ImageProcessor processor);

    /**
     * 设置ScaleType，ImageProcessor会根据resize和ScaleType创建一张新的图片
     * @param scaleType ScaleType
     * @return DisplayHelper
     */
    DisplayHelper scaleType(ImageView.ScaleType scaleType);

    /**
     * 关闭内存缓存
     * @return DisplayHelper
     */
    DisplayHelper disableMemoryCache();

    /**
     * 加载gif图片
     * @return DisplayHelper
     */
    DisplayHelper thisIsGifImage();

    /**
     * 设置显示监听器
     * @param displayListener 显示监听器
     */
    DisplayHelper listener(DisplayListener displayListener);

    /**
     * 设置图片显示器，在加载完成后会调用此显示器来显示图片
     * @param displayer 图片显示器
     */
    DisplayHelper displayer(ImageDisplayer displayer);

    /**
     * 设置正在加载时显示的图片
     * @param drawableResId 资源图片ID
     */
    DisplayHelper loadingDrawable(int drawableResId);

    /**
     * 设置正在加载时显示的图片
     * @param drawableResId 资源图片ID
     * @param isProcess 是否使用ImageProcessor处理
     */
    DisplayHelper loadingDrawable(int drawableResId, boolean isProcess);

    /**
     * 设置加载失败时显示的图片
     * @param drawableResId 资源图片ID
     */
    DisplayHelper loadFailDrawable(int drawableResId);

    /**
     * 设置加载失败时显示的图片
     * @param drawableResId 资源图片ID
     * @param isProcess 是否使用ImageProcessor处理
     */
    DisplayHelper loadFailDrawable(int drawableResId, boolean isProcess);

    /**
     * 设置加载失败时显示的图片
     * @param drawableResId 资源图片ID
     */
    DisplayHelper pauseDownloadDrawable(int drawableResId);

    /**
     * 设置暂停下载时显示的图片
     * @param drawableResId 资源图片ID
     * @param isProcess 是否使用ImageProcessor处理
     */
    DisplayHelper pauseDownloadDrawable(int drawableResId, boolean isProcess);

    /**
     * 设置进度监听器
     * @param progressListener 进度监听器
     * @return DisplayHelper
     */
    DisplayHelper progressListener(ProgressListener progressListener);

    /**
     * 设置加载级别
     * @param requestHandleLevel 加载级别
     * @return DisplayHelper
     */
    DisplayHelper level(RequestHandleLevel requestHandleLevel);

    /**
     * 设置显示参数
     * @param options 显示参数
     * @return DisplayHelper
     */
    DisplayHelper options(DisplayOptions options);

    /**
     * 设置显示参数，你只需要提前将DisplayOptions通过Spear.putOptions()方法存起来，然后在这里指定其名称即可
     * @param optionsName 参数名称
     * @return DisplayHelper
     */
    DisplayHelper options(Enum<?> optionsName);

    /**
     * 执行请求
     * @return Request 你可以通过Request来查看请求的状态或者取消这个请求
     */
    Request fire();

    /**
     * 生成内存缓存ID
     */
    String generateMemoryCacheId(String uri, ImageSize maxsize, ImageSize resize, ImageView.ScaleType scaleType, ImageProcessor imageProcessor);
}
