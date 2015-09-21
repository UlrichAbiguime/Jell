#include <experta_jell_utilz_Functionz.h>


JNIEXPORT jlong JNICALL Java_experta_jell_utilz_Functionz_fibNr
        (JNIEnv *env, jclass clazz, jlong n) {
    return n <= 0 ? 0 : n==1?1: Java_experta_jell_utilz_Functionz_fibNr(env, clazz, n-1)+
                                Java_experta_jell_utilz_Functionz_fibNr(env, clazz, n-2);
}