//
// Created by diptadipsi on 09/12/20.
//

#include <jni.h>

extern "C" JNIEXPORT jint JNICALL
Java_id_ac_ui_cs_mobileprogramming_rdpradiptagitayas_learntktpl_views_MainActivity_getCounter(
        JNIEnv *env, jobject obj, jint current_counter) {
    return current_counter + 1;
}