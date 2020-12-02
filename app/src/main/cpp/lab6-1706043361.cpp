//
// Created by diptadipsi on 02/12/20.
//

#include <jni.h>

extern "C" JNIEXPORT jint JNICALL
Java_id_ac_ui_cs_mobileprogramming_rdpradiptagitayas_learntktpl_views_MainActivity_sumNumbers(
        JNIEnv *env, jobject obj, jint first_num, jint second_num) {
    return first_num + second_num;
}