# Add "Build Analyzer" and "Static Stack Analyzer" from the STM32 CubeIDE to the AC6 SW4STM32 toolchain

## Usage
1. Go to the release page, download the 3 jar files into your "eclipse\plugins" folder.
2. Download STM32 Cube IDE plugin for Eclipse, only copying the following from "cubeide\plugins" to "eclipse\plugins", the actual name might be slightly different:
```
com.st.stm32cube.common.logger_1.0.0.201904101131 (Folder)
com.st.stm32cube.common.utils_1.1.0.201910081157 (Folder)

com.st.stm32cube.ide.common.ui.oss_1.0.0.201904021149.jar
com.st.stm32cube.ide.common.ui_1.2.0.201912201802.jar
com.st.stm32cube.ide.common.utils_1.1.0.201910081157.jar
com.st.stm32cube.ide.mcu.buildanalyzer_1.2.0.201912201802.jar
com.st.stm32cube.ide.mcu.externaltools.oss_1.0.0.201904021149.jar
com.st.stm32cube.ide.mcu.stackanalyzer_1.1.0.201910081157.jar
com.st.stm32cube.ide.mcu.toolchain.utils_1.0.0.201904021149.jar
```
3. Use Winrar or 7zip to open `com.st.stm32cube.ide.mcu.stackanalyzer_1.1.0.201910081157.jar`, extract `META-INF\MANIFEST.MF`, delete `com.st.stm32cube.ide.mcu.debug,` and then overwrite the file in the jar with the modified one.
4. Launch Eclipse, you should be able to open the "Build Analyzer" and the "Static Stack Analyzer" from the "View" menu.
5. If not working, try "eclipse -clean".
6. Append ` -fstack-usage` flag to `C/C++ Build -> Settings -> Tool Settings -> MCU GCC Compiler -> Miscellaneous -> Other flags` (__per project setting__)
7. Change `C/C++ Build -> Settings -> Tool Settings -> MCU GCC LINKER -> General -> Generated Map (-WI, -Map=)` to `${ProjName}.map` (__per project setting__)

__Warning: Do not install with STM32 CubeIDE plugin! (Conficts and duplicated function)__

## Compile this project
This project requires the Eclipse SDK to compile.


## References:
1. https://www.eclipse.org/eclipse/platform-core/documents/3.1/debug.html
1. https://gist.github.com/rikka0w0/8d7218a3465bcdde85caec27c58deee1