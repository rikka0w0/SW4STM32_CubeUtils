package com.st.stm32cube.ide.mcu.toolchain;

public interface IToolChainInfo extends Comparable<IToolChainInfo> {
	String getFullQualifiedId();

	String getBuildOptionPrefixId();

	String getToolCCompilerId();

	String getToolCCompilerIncludepathId();

	String getToolAssemblerId();

	String getToolAssemblerIncludepathId();

	String getToolCppCompilerId();

	String getToolCppCompilerIncludepathId();
}
