package com.tsinghua.course.Biz.Processor;

import com.tsinghua.course.Base.Constant.KeyConstant;
import com.tsinghua.course.Biz.Controller.Params.FileParams.In.File_UploadParams_In;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * @描述 文件原子处理器，所有与文件相关的原子操作都在此处理器中执行
**/
@Component
public class FileProcessor {
    // 存文件
    public String uploadFile(File_UploadParams_In inParams){
        try {
            File file = inParams.getFile().getFile();
            String time = String.valueOf(System.currentTimeMillis());
            String filename = time + "_" + inParams.getFile().getFilename();

            File file1 = new File(KeyConstant.FILE_STORE_PATH);
            if (!file1.exists())
                file1.mkdirs();

            File file2 = new File(KeyConstant.FILE_STORE_PATH, filename);
            if (!file2.exists())
                file2.createNewFile();

            FileInputStream input = new FileInputStream(file);
            String url = KeyConstant.FILE_STORE_PATH + "/" + filename;
            FileOutputStream output = new FileOutputStream(url);

            byte b[] = new byte[128];
            while( input.read(b) != -1 )
                output.write(b);

            input.close();
            output.close();
            return  url;
        } catch (Exception e) {
            return null;
        }
    }
}
