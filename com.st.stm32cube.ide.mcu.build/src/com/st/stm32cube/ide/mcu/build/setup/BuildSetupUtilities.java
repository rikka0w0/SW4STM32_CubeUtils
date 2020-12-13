package com.st.stm32cube.ide.mcu.build.setup;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.eclipse.cdt.managedbuilder.core.BuildException;
import org.eclipse.cdt.managedbuilder.core.IConfiguration;
import org.eclipse.cdt.managedbuilder.core.IOption;
import org.eclipse.cdt.managedbuilder.core.ITool;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;

import com.st.stm32cube.ide.mcu.build.MCUBuildPlugin;
import com.st.stm32cube.ide.mcu.toolchain.IToolChainInfo;
import com.st.stm32cube.ide.mcu.toolchain.ToolChainHelper;

public class BuildSetupUtilities {
	private static Collection<String> getIncludePaths(IConfiguration config, String toolId, String optionId)
			throws BuildException, CoreException {
		if (config == null) {
			throw new CoreException(new Status(4, MCUBuildPlugin.getUniqueIdentifier(),
					"BuildSetup_NullConfiguration_Error_Text"));
		}

		ITool[] tools = config.getToolChain().getToolsBySuperClassId(toolId);
		for (int i = 0; i < tools.length; i++) {
			ITool tool = tools[i];
			IOption option = tool.getOptionBySuperClassId(optionId);
			if (option != null)
				return new HashSet<>(Arrays.asList(option.getIncludePaths()));
		}

		return new HashSet<>();
	}

	public static Collection<String> getCIncludePaths(IConfiguration config) throws CoreException, BuildException {
	    IProject project = (IProject)config.getManagedProject().getOwner();	    
	    
	    if (project.getNature("org.eclipse.cdt.core.cnature") != null) {
	    	// for (ITool tool:config.getToolChain().getTools()) {
	    	// 	System.out.println(tool.getId());
	    	// }

	    	// C project
	    	Set<String> symbols = new HashSet<>();
	    	IToolChainInfo tcInfo = ToolChainHelper.getToolChainInfo(config);
	    	symbols.addAll(getIncludePaths(config, tcInfo.getToolCCompilerId(), tcInfo.getToolCCompilerIncludepathId()));

	    	if (project.getNature("org.eclipse.cdt.core.ccnature") != null) {
	    		// C++ project
	    		symbols.addAll(getIncludePaths(config, tcInfo.getToolCppCompilerId(), tcInfo.getToolCppCompilerIncludepathId()));
	    	}

	    	return symbols;
	    }

	    return Collections.emptySet();
	}

	public static Collection<String> getASMIncludePaths(IConfiguration config) throws CoreException, BuildException {
		IToolChainInfo tcInfo = ToolChainHelper.getToolChainInfo(config);
		return getIncludePaths(config, tcInfo.getToolCCompilerId(), tcInfo.getToolAssemblerIncludepathId());
	}

	private static final Optional<String> defaultPrefix = Optional.of("arm-none-eabi-");
	public static Optional<String> getPrefix(IConfiguration config) {
		return defaultPrefix;
	}
}