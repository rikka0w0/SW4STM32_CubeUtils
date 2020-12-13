package com.st.stm32cube.ide.mcu.externaltools;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.eclipse.core.runtime.Plugin;

import com.st.stm32cube.common.logger.MCULoggerPlugin;

public class MCUExternalToolsPlugin extends Plugin {
	public static String getCompilerLocation(String id)
			throws InterruptedException, URISyntaxException, IOException, IllegalArgumentException {
		String compilerPath = System.getProperty("custom_toolchain_loc");

		if (compilerPath == null || compilerPath.isEmpty()) {
			// Attempt to find the toolchain from installed AC6 if "custom_toolchain_loc" is not set
			File eclipseDir = new File("plugins");
			File[] toolchainDirs = eclipseDir.listFiles((pathname) -> 
				pathname.isDirectory() && pathname.getName().startsWith("fr.ac6.mcu.externaltools.arm-none.")
			);
			if (toolchainDirs != null) {
				compilerPath = Paths.get(toolchainDirs[0].getAbsolutePath(), "tools", "compiler").toString();
			}
		}

		if (compilerPath == null || compilerPath.isEmpty()) {
			MCULoggerPlugin.logException("com.st.stm32cube.ide.mcu.externaltools", new Throwable(String
					.format("[WARNING] : getCompilerLocation(%s) returns '%s'", new Object[] { id, compilerPath })));
		}

		return compilerPath + File.separator + "bin";
	}
}
