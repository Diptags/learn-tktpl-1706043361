cmake_minimum_required(VERSION 3.10.2)

project("learntktpl")

add_library(lab7-1706043361
        SHARED
        src/main/cpp/lab7-1706043361.cpp)

find_library(
        log-lib
        log )

target_link_libraries(
        lab7-1706043361
        ${log-lib} )