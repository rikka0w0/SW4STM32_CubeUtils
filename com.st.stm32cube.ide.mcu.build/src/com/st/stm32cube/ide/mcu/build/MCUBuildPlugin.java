package com.st.stm32cube.ide.mcu.build;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class MCUBuildPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.st.stm32cube.ide.mcu.build"; //$NON-NLS-1$

	// The shared instance
	private static MCUBuildPlugin plugin;
	
	/**
	 * The constructor
	 */
	public MCUBuildPlugin() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static MCUBuildPlugin getDefault() {
		return plugin;
	}

	public static String getUniqueIdentifier() {
		if (getDefault() == null)
			return "com.st.stm32cube.ide.mcu.build";
		return getDefault().getBundle().getSymbolicName();
	}
}
