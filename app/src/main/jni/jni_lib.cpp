#include <jni.h>
#include <string>
#include "sample.h"

extern "C"
JNIEXPORT jstring JNICALL
Java_jp_k_green_protoapp_domain_JniWrapper_stringFromJNI(
        JNIEnv *env, jobject /* this */) {
    std::string hello = "Hello from C++" + sample();
    return env->NewStringUTF(hello.c_str());
}
