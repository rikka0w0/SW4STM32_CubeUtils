package com.st.stm32cube.ide.mcu.toolchain;

import org.eclipse.cdt.managedbuilder.core.IConfiguration;

public class ToolChainHelper {
	private static IToolChainInfo defaultToolChain = new IToolChainInfo() {
		@Override
		public int compareTo(IToolChainInfo o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public String getFullQualifiedId() {
			return null;
		}
		
		@Override
		public String getBuildOptionPrefixId() {
			return "fr.ac6.managedbuild.option.gnu.cross.prefix";
		}

		@Override
		public String getToolCCompilerId() {
			return "fr.ac6.managedbuild.tool.gnu.cross.c.compiler";
		}

		@Override
		public String getToolCCompilerIncludepathId() {
			return "gnu.c.compiler.option.include.paths";
		}

		@Override
		public String getToolAssemblerId() {
			return "fr.ac6.managedbuild.tool.gnu.cross.assembler";
		}

		@Override
		public String getToolAssemblerIncludepathId() {
			return "gnu.both.asm.option.include.paths";
		}

		@Override
		public String getToolCppCompilerId() {
			return "fr.ac6.managedbuild.tool.gnu.cross.cpp.compiler";
		}

		@Override
		public String getToolCppCompilerIncludepathId() {
			return "gnu.cpp.compiler.option.include.paths";
		}
	};

	public static IToolChainInfo getDefaultToolChain() {
		return defaultToolChain;
	}

	public static IToolChainInfo getToolChainInfo(IConfiguration config) {
		return defaultToolChain;
	}
}
