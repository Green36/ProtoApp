#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_jp_k_green_protoapp_domain_JniWrapper_stringFromJNI(
        JNIEnv *env, jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
