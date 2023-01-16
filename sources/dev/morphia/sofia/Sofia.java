package dev.morphia.sofia;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import net.bytebuddy.utility.JavaConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:dev/morphia/sofia/Sofia.class */
public class Sofia {
    private static final Logger logger = LoggerFactory.getLogger("dev.morphia.sofia.Sofia");
    private static final Map<String, Localized> IMPLS = new HashMap();

    static {
        IMPLS.put("", new LocalizedImpl());
    }

    private static Localized get(Locale... locale) {
        if (locale.length == 0) {
            return IMPLS.get("");
        }
        String name = locale[0].toString();
        while (!name.isEmpty()) {
            Localized localized = IMPLS.get(name);
            if (localized != null) {
                return localized;
            }
            name = name.contains(JavaConstant.Dynamic.DEFAULT_NAME) ? name.substring(0, name.lastIndexOf(95)) : "";
        }
        return IMPLS.get("");
    }

    public static String callingInterceptorMethod(Object arg0, Object arg1, Locale... locale) {
        return get(locale).callingInterceptorMethod(arg0, arg1, new Locale[0]);
    }

    public static void logCallingInterceptorMethod(Object arg0, Object arg1, Locale... locale) {
        if (logger.isDebugEnabled()) {
            logger.debug(callingInterceptorMethod(arg0, arg1, locale));
        }
    }

    public static String callingLifecycleMethod(Object arg0, Object arg1, Object arg2, Locale... locale) {
        return get(locale).callingLifecycleMethod(arg0, arg1, arg2, new Locale[0]);
    }

    public static void logCallingLifecycleMethod(Object arg0, Object arg1, Object arg2, Locale... locale) {
        if (logger.isDebugEnabled()) {
            logger.debug(callingLifecycleMethod(arg0, arg1, arg2, locale));
        }
    }

    public static String foundUnannotatedClass(Object arg0, Locale... locale) {
        return get(locale).foundUnannotatedClass(arg0, new Locale[0]);
    }

    public static void logFoundUnannotatedClass(Object arg0, Locale... locale) {
        if (logger.isWarnEnabled()) {
            logger.warn(foundUnannotatedClass(arg0, locale));
        }
    }

    public static String ignoringTransientProperty(Object arg0, Locale... locale) {
        return get(locale).ignoringTransientProperty(arg0, new Locale[0]);
    }

    public static void logIgnoringTransientProperty(Object arg0, Locale... locale) {
        if (logger.isWarnEnabled()) {
            logger.warn(ignoringTransientProperty(arg0, locale));
        }
    }

    public static String moreThanOneMapper(Object arg0, Object arg1, Locale... locale) {
        return get(locale).moreThanOneMapper(arg0, arg1, new Locale[0]);
    }

    public static void logMoreThanOneMapper(Object arg0, Object arg1, Locale... locale) {
        if (logger.isWarnEnabled()) {
            logger.warn(moreThanOneMapper(arg0, arg1, locale));
        }
    }

    public static String noMappedClasses(Locale... locale) {
        return get(locale).noMappedClasses(new Locale[0]);
    }

    public static void logNoMappedClasses(Locale... locale) {
        if (logger.isWarnEnabled()) {
            logger.warn(noMappedClasses(locale));
        }
    }

    public static String testFeatureOnly(Locale... locale) {
        return get(locale).testFeatureOnly(new Locale[0]);
    }

    public static void logTestFeatureOnly(Locale... locale) {
        if (logger.isWarnEnabled()) {
            logger.warn(testFeatureOnly(locale));
        }
    }

    public static String unsetNamesDollarSign(Locale... locale) {
        return get(locale).unsetNamesDollarSign(new Locale[0]);
    }

    public static void logUnsetNamesDollarSign(Locale... locale) {
        if (logger.isWarnEnabled()) {
            logger.warn(unsetNamesDollarSign(locale));
        }
    }

    public static String aggregationFailed(Object arg0, Locale... locale) {
        return get(locale).aggregationFailed(arg0, new Locale[0]);
    }

    public static String alreadyAtRoot(Locale... locale) {
        return get(locale).alreadyAtRoot(new Locale[0]);
    }

    public static String atLeastOneUpdateRequired(Locale... locale) {
        return get(locale).atLeastOneUpdateRequired(new Locale[0]);
    }

    public static String cannotFindTypeInDocument(Locale... locale) {
        return get(locale).cannotFindTypeInDocument(new Locale[0]);
    }

    public static String cannotInstantiate(Object arg0, Object arg1, Locale... locale) {
        return get(locale).cannotInstantiate(arg0, arg1, new Locale[0]);
    }

    public static String cannotPersistNullEntity(Locale... locale) {
        return get(locale).cannotPersistNullEntity(new Locale[0]);
    }

    public static String cannotReadName(Locale... locale) {
        return get(locale).cannotReadName(new Locale[0]);
    }

    public static String cantStartArray(Object arg0, Locale... locale) {
        return get(locale).cantStartArray(arg0, new Locale[0]);
    }

    public static String cantStartDocument(Object arg0, Locale... locale) {
        return get(locale).cantStartDocument(arg0, new Locale[0]);
    }

    public static String collectionNotMapped(Object arg0, Locale... locale) {
        return get(locale).collectionNotMapped(arg0, new Locale[0]);
    }

    public static String concurrentModification(Object arg0, Object arg1, Locale... locale) {
        return get(locale).concurrentModification(arg0, arg1, new Locale[0]);
    }

    public static String contradictingAnnotations(Object arg0, Object arg1, Locale... locale) {
        return get(locale).contradictingAnnotations(arg0, arg1, new Locale[0]);
    }

    public static String conversionNotSupported(Object arg0, Locale... locale) {
        return get(locale).conversionNotSupported(arg0, new Locale[0]);
    }

    public static String deleteWithClass(Object arg0, Locale... locale) {
        return get(locale).deleteWithClass(arg0, new Locale[0]);
    }

    public static String documentStreamExceeded(Locale... locale) {
        return get(locale).documentStreamExceeded(new Locale[0]);
    }

    public static String duplicatedMappedName(Object arg0, Object arg1, Locale... locale) {
        return get(locale).duplicatedMappedName(arg0, arg1, new Locale[0]);
    }

    public static String duplicatedParameterName(Object arg0, Object arg1, Locale... locale) {
        return get(locale).duplicatedParameterName(arg0, arg1, new Locale[0]);
    }

    public static String encodingOnly(Locale... locale) {
        return get(locale).encodingOnly(new Locale[0]);
    }

    public static String entityOrEmbedded(Object arg0, Locale... locale) {
        return get(locale).entityOrEmbedded(arg0, new Locale[0]);
    }

    public static String fieldCannotBeNull(Locale... locale) {
        return get(locale).fieldCannotBeNull(new Locale[0]);
    }

    public static String filterMappingNotSupported(Object arg0, Locale... locale) {
        return get(locale).filterMappingNotSupported(arg0, new Locale[0]);
    }

    public static String groupIdAlreadyDefined(Locale... locale) {
        return get(locale).groupIdAlreadyDefined(new Locale[0]);
    }

    public static String idRequired(Object arg0, Locale... locale) {
        return get(locale).idRequired(arg0, new Locale[0]);
    }

    public static String illegalArgument(Object arg0, Object arg1, Locale... locale) {
        return get(locale).illegalArgument(arg0, arg1, new Locale[0]);
    }

    public static String instantiationProblem(Object arg0, Object arg1, Locale... locale) {
        return get(locale).instantiationProblem(arg0, arg1, new Locale[0]);
    }

    public static String invalidAnnotationCombination(Object arg0, Object arg1, Locale... locale) {
        return get(locale).invalidAnnotationCombination(arg0, arg1, new Locale[0]);
    }

    public static String invalidBsonOperation(Object arg0, Object arg1, Locale... locale) {
        return get(locale).invalidBsonOperation(arg0, arg1, new Locale[0]);
    }

    public static String invalidIndexPath(Object arg0, Object arg1, Locale... locale) {
        return get(locale).invalidIndexPath(arg0, arg1, new Locale[0]);
    }

    public static String invalidPathTarget(Object arg0, Object arg1, Object arg2, Locale... locale) {
        return get(locale).invalidPathTarget(arg0, arg1, arg2, new Locale[0]);
    }

    public static String invalidReaderState(Object arg0, Object arg1, Object arg2, Locale... locale) {
        return get(locale).invalidReaderState(arg0, arg1, arg2, new Locale[0]);
    }

    public static String keyNotAllowedAsProperty(Locale... locale) {
        return get(locale).keyNotAllowedAsProperty(new Locale[0]);
    }

    public static String legacyOperation(Locale... locale) {
        return get(locale).legacyOperation(new Locale[0]);
    }

    public static String loggedQuery(Object arg0, Locale... locale) {
        return get(locale).loggedQuery(arg0, new Locale[0]);
    }

    public static String mapperOptionsLocked(Locale... locale) {
        return get(locale).mapperOptionsLocked(new Locale[0]);
    }

    public static String misnamedConstructorParameter(Object arg0, Object arg1, Locale... locale) {
        return get(locale).misnamedConstructorParameter(arg0, arg1, new Locale[0]);
    }

    public static String missingReferencedEntities(Object arg0, Locale... locale) {
        return get(locale).missingReferencedEntities(arg0, new Locale[0]);
    }

    public static String missingReferencedEntity(Object arg0, Locale... locale) {
        return get(locale).missingReferencedEntity(arg0, new Locale[0]);
    }

    public static String mixedGroupIdDefinition(Locale... locale) {
        return get(locale).mixedGroupIdDefinition(new Locale[0]);
    }

    public static String mixedModeProjections(Locale... locale) {
        return get(locale).mixedModeProjections(new Locale[0]);
    }

    public static String mixedModesNotAllowed(Object arg0, Locale... locale) {
        return get(locale).mixedModesNotAllowed(arg0, new Locale[0]);
    }

    public static String mixedProjections(Locale... locale) {
        return get(locale).mixedProjections(new Locale[0]);
    }

    public static String mixedUpdateOperationsNotAllowed(Locale... locale) {
        return get(locale).mixedUpdateOperationsNotAllowed(new Locale[0]);
    }

    public static String multipleIdPropertiesFound(Object arg0, Locale... locale) {
        return get(locale).multipleIdPropertiesFound(arg0, new Locale[0]);
    }

    public static String noIdForReference(Locale... locale) {
        return get(locale).noIdForReference(new Locale[0]);
    }

    public static String noIdPropertyFound(Object arg0, Locale... locale) {
        return get(locale).noIdPropertyFound(arg0, new Locale[0]);
    }

    public static String noInnerClasses(Object arg0, Locale... locale) {
        return get(locale).noInnerClasses(arg0, new Locale[0]);
    }

    public static String noMappedCollection(Object arg0, Locale... locale) {
        return get(locale).noMappedCollection(arg0, new Locale[0]);
    }

    public static String noSuitableConstructor(Object arg0, Locale... locale) {
        return get(locale).noSuitableConstructor(arg0, new Locale[0]);
    }

    public static String noargConstructorNotFound(Object arg0, Locale... locale) {
        return get(locale).noargConstructorNotFound(arg0, new Locale[0]);
    }

    public static String notArrayEnd(Locale... locale) {
        return get(locale).notArrayEnd(new Locale[0]);
    }

    public static String notAvailableInLegacy(Locale... locale) {
        return get(locale).notAvailableInLegacy(new Locale[0]);
    }

    public static String notDocumentEnd(Locale... locale) {
        return get(locale).notDocumentEnd(new Locale[0]);
    }

    public static String notDocumentType(Locale... locale) {
        return get(locale).notDocumentType(new Locale[0]);
    }

    public static String notInValidState(Object arg0, Object arg1, Locale... locale) {
        return get(locale).notInValidState(arg0, arg1, new Locale[0]);
    }

    public static String notMappable(Object arg0, Locale... locale) {
        return get(locale).notMappable(arg0, new Locale[0]);
    }

    public static String notNull(Object arg0, Locale... locale) {
        return get(locale).notNull(arg0, new Locale[0]);
    }

    public static String notTopLevelType(Locale... locale) {
        return get(locale).notTopLevelType(new Locale[0]);
    }

    public static String nullUpdateEntity(Locale... locale) {
        return get(locale).nullUpdateEntity(new Locale[0]);
    }

    public static String onlyNumberTypesAllowed(Locale... locale) {
        return get(locale).onlyNumberTypesAllowed(new Locale[0]);
    }

    public static String persistenceNotIntended(Locale... locale) {
        return get(locale).persistenceNotIntended(new Locale[0]);
    }

    public static String queryNotLogged(Locale... locale) {
        return get(locale).queryNotLogged(new Locale[0]);
    }

    public static String referredTypeMissingId(Object arg0, Object arg1, Locale... locale) {
        return get(locale).referredTypeMissingId(arg0, arg1, new Locale[0]);
    }

    public static String translationNotCurrentlySupported(Locale... locale) {
        return get(locale).translationNotCurrentlySupported(new Locale[0]);
    }

    public static String unbalancedOpens(Object arg0, Object arg1, Object arg2, Locale... locale) {
        return get(locale).unbalancedOpens(arg0, arg1, arg2, new Locale[0]);
    }

    public static String unhandledTypeData(Object arg0, Locale... locale) {
        return get(locale).unhandledTypeData(arg0, new Locale[0]);
    }

    public static String unmappedType(Object arg0, Locale... locale) {
        return get(locale).unmappedType(arg0, new Locale[0]);
    }

    public static String unnamedConstructorParameter(Object arg0, Locale... locale) {
        return get(locale).unnamedConstructorParameter(arg0, new Locale[0]);
    }

    public static String updateSortOptions(Object arg0, Object arg1, Locale... locale) {
        return get(locale).updateSortOptions(arg0, arg1, new Locale[0]);
    }

    public static String valueCannotBeNull(Locale... locale) {
        return get(locale).valueCannotBeNull(new Locale[0]);
    }

    public static String valuesCannotBeNullOrEmpty(Locale... locale) {
        return get(locale).valuesCannotBeNullOrEmpty(new Locale[0]);
    }

    public static String versionManuallySet(Locale... locale) {
        return get(locale).versionManuallySet(new Locale[0]);
    }

    public static String versionedUpdateOnNonversionedEntity(Locale... locale) {
        return get(locale).versionedUpdateOnNonversionedEntity(new Locale[0]);
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:dev/morphia/sofia/Sofia$Localized.class */
    public interface Localized {
        default String callingInterceptorMethod(Object arg0, Object arg1, Locale... locale) {
            return MessageFormat.format("Calling interceptor method {0} on {1}", arg0, arg1);
        }

        default void logCallingInterceptorMethod(Object arg0, Object arg1, Locale... locale) {
            if (Sofia.logger.isDebugEnabled()) {
                Sofia.logger.debug(callingInterceptorMethod(arg0, arg1, locale));
            }
        }

        default String callingLifecycleMethod(Object arg0, Object arg1, Object arg2, Locale... locale) {
            return MessageFormat.format("Calling lifecycle method(@{0} {1}) on {2}", arg0, arg1, arg2);
        }

        default void logCallingLifecycleMethod(Object arg0, Object arg1, Object arg2, Locale... locale) {
            if (Sofia.logger.isDebugEnabled()) {
                Sofia.logger.debug(callingLifecycleMethod(arg0, arg1, arg2, locale));
            }
        }

        default String foundUnannotatedClass(Object arg0, Locale... locale) {
            return MessageFormat.format("Unannotated class found:  {0}.  Unannotated classes are not allowed when scanning packages.  If you want this class mapped, please call map() and explicitly pass this class reference in.", arg0);
        }

        default void logFoundUnannotatedClass(Object arg0, Locale... locale) {
            if (Sofia.logger.isWarnEnabled()) {
                Sofia.logger.warn(foundUnannotatedClass(arg0, locale));
            }
        }

        default String ignoringTransientProperty(Object arg0, Locale... locale) {
            return MessageFormat.format("{0} is marked as transient and will not be persisted.", arg0);
        }

        default void logIgnoringTransientProperty(Object arg0, Locale... locale) {
            if (Sofia.logger.isWarnEnabled()) {
                Sofia.logger.warn(ignoringTransientProperty(arg0, locale));
            }
        }

        default String moreThanOneMapper(Object arg0, Object arg1, Locale... locale) {
            return MessageFormat.format("Found more than one class mapped to collection ''{0}'': {1}", arg0, arg1);
        }

        default void logMoreThanOneMapper(Object arg0, Object arg1, Locale... locale) {
            if (Sofia.logger.isWarnEnabled()) {
                Sofia.logger.warn(moreThanOneMapper(arg0, arg1, locale));
            }
        }

        default String noMappedClasses(Locale... locale) {
            return "No classes have been mapped.";
        }

        default void logNoMappedClasses(Locale... locale) {
            if (Sofia.logger.isWarnEnabled()) {
                Sofia.logger.warn(noMappedClasses(locale));
            }
        }

        default String testFeatureOnly(Locale... locale) {
            return "This feature is intended for testing and debugging only.";
        }

        default void logTestFeatureOnly(Locale... locale) {
            if (Sofia.logger.isWarnEnabled()) {
                Sofia.logger.warn(testFeatureOnly(locale));
            }
        }

        default String unsetNamesDollarSign(Locale... locale) {
            return "Field names in a $unset can not start with ''$''.  Automatically stripping the ''$'' from the names.";
        }

        default void logUnsetNamesDollarSign(Locale... locale) {
            if (Sofia.logger.isWarnEnabled()) {
                Sofia.logger.warn(unsetNamesDollarSign(locale));
            }
        }

        default String aggregationFailed(Object arg0, Locale... locale) {
            return MessageFormat.format("Failed to execute the aggregation pipeline:  {0}", arg0);
        }

        default String alreadyAtRoot(Locale... locale) {
            return "No previous state found.  Already at the root.";
        }

        default String atLeastOneUpdateRequired(Locale... locale) {
            return "At least one update operation is required.";
        }

        default String cannotFindTypeInDocument(Locale... locale) {
            return "No type information found in the document.";
        }

        default String cannotInstantiate(Object arg0, Object arg1, Locale... locale) {
            return MessageFormat.format("The type ''{0}'' can not be instantiated: {1}", arg0, arg1);
        }

        default String cannotPersistNullEntity(Locale... locale) {
            return "Can not persist a null entity.";
        }

        default String cannotReadName(Locale... locale) {
            return "name() can''t called when iterating List values";
        }

        default String cantStartArray(Object arg0, Locale... locale) {
            return MessageFormat.format("Can not start a new array while in state: {0}", arg0);
        }

        default String cantStartDocument(Object arg0, Locale... locale) {
            return MessageFormat.format("Can not start a new document while in state: {0}", arg0);
        }

        default String collectionNotMapped(Object arg0, Locale... locale) {
            return MessageFormat.format("The collection ''{0}'' is not mapped to a java class.", arg0);
        }

        default String concurrentModification(Object arg0, Object arg1, Locale... locale) {
            return MessageFormat.format("Entity of type {0} (id={1}) was not persisted. Either it was modified by another process or was improperly initialized.  See the versioning documentation for more details.", arg0, arg1);
        }

        default String contradictingAnnotations(Object arg0, Object arg1, Locale... locale) {
            return MessageFormat.format("A property can be either annotated with @{0} OR @{1}, but not both.", arg0, arg1);
        }

        default String conversionNotSupported(Object arg0, Locale... locale) {
            return MessageFormat.format("No conversion exists yet for this type:  {0}", arg0);
        }

        default String deleteWithClass(Object arg0, Locale... locale) {
            return MessageFormat.format("Did you mean to delete all documents? Try ds.find({0}.class).delete()", arg0);
        }

        default String documentStreamExceeded(Locale... locale) {
            return "No more elements remaining";
        }

        default String duplicatedMappedName(Object arg0, Object arg1, Locale... locale) {
            return MessageFormat.format("Duplicated mapped name found on {0}: {1}", arg0, arg1);
        }

        default String duplicatedParameterName(Object arg0, Object arg1, Locale... locale) {
            return MessageFormat.format("Duplicated parameter name found on {0}: {1}", arg0, arg1);
        }

        default String encodingOnly(Locale... locale) {
            return "This codec is for encoding only.";
        }

        default String entityOrEmbedded(Object arg0, Locale... locale) {
            return MessageFormat.format("{0} must be annotated with either @Entity or @Embedded.", arg0);
        }

        default String fieldCannotBeNull(Locale... locale) {
            return "Field name can not be null.";
        }

        default String filterMappingNotSupported(Object arg0, Locale... locale) {
            return MessageFormat.format("Conversion of {0} is not currently supported.", arg0);
        }

        default String groupIdAlreadyDefined(Locale... locale) {
            return "An _id for this group has already been defined.";
        }

        default String idRequired(Object arg0, Locale... locale) {
            return MessageFormat.format("An @Id property is required on top level entities.  {0} does not have an @Id property.", arg0);
        }

        default String illegalArgument(Object arg0, Object arg1, Locale... locale) {
            return MessageFormat.format("Illegal argument of type {0} given where a type of {1} was expected.", arg0, arg1);
        }

        default String instantiationProblem(Object arg0, Object arg1, Locale... locale) {
            return MessageFormat.format("Can''t instantiate the type {0}: {1}", arg0, arg1);
        }

        default String invalidAnnotationCombination(Object arg0, Object arg1, Locale... locale) {
            return MessageFormat.format("{0} is annotated with @{1} and cannot be mixed with other annotations (like @Reference)", arg0, arg1);
        }

        default String invalidBsonOperation(Object arg0, Object arg1, Locale... locale) {
            return MessageFormat.format("Value expected to be of type {0} is of unexpected type {1}", arg0, arg1);
        }

        default String invalidIndexPath(Object arg0, Object arg1, Locale... locale) {
            return MessageFormat.format("The path ''{0}'' can not be validated against ''{1}'' and may represent an invalid index", arg0, arg1);
        }

        default String invalidPathTarget(Object arg0, Object arg1, Object arg2, Locale... locale) {
            return MessageFormat.format("Could not resolve path ''{0}'' against ''{1}''.  Unknown path element: ''{2}''.", arg0, arg1, arg2);
        }

        default String invalidReaderState(Object arg0, Object arg1, Object arg2, Locale... locale) {
            return MessageFormat.format("{0} can only be called when State is {1}, not when State is {2}.\"", arg0, arg1, arg2);
        }

        default String keyNotAllowedAsProperty(Locale... locale) {
            return "Keys are not allowed as properties.  Use (lazy) references instead.";
        }

        default String legacyOperation(Locale... locale) {
            return "This is a legacy operation and is not supported on this version of the API.";
        }

        default String loggedQuery(Object arg0, Locale... locale) {
            return MessageFormat.format("logged query: {0}", arg0);
        }

        default String mapperOptionsLocked(Locale... locale) {
            return "This Builder has already been built and is now locked.  To update an existing set of options use builder(MapperOptions) to create a new Builder.";
        }

        default String misnamedConstructorParameter(Object arg0, Object arg1, Locale... locale) {
            return MessageFormat.format("Named constructor parameter ''{1}'' does not match mapped property on {0}.", arg0, arg1);
        }

        default String missingReferencedEntities(Object arg0, Locale... locale) {
            return MessageFormat.format("Referenced ''{0}'' entities could not be found during a fetch.", arg0);
        }

        default String missingReferencedEntity(Object arg0, Locale... locale) {
            return MessageFormat.format("Referenced ''{0}'' entity could not be found during a fetch.", arg0);
        }

        default String mixedGroupIdDefinition(Locale... locale) {
            return "A group ID can either reference a field (e.g., \"$name\") or have a list of expressions but not both.";
        }

        default String mixedModeProjections(Locale... locale) {
            return "Only one form of projection allowed at a time.";
        }

        default String mixedModesNotAllowed(Object arg0, Locale... locale) {
            return MessageFormat.format("{0} can either take a single value or a document but not both.", arg0);
        }

        default String mixedProjections(Locale... locale) {
            return "Projections can not mix included and excluded fields together.";
        }

        default String mixedUpdateOperationsNotAllowed(Locale... locale) {
            return "Individual fields can not be updated when $setting the document itself.";
        }

        default String multipleIdPropertiesFound(Object arg0, Locale... locale) {
            return MessageFormat.format("\"More than one @Id property found ({0}).\"", arg0);
        }

        default String noIdForReference(Locale... locale) {
            return "No ID found for referenced entity.  Ensure referenced entities are saved first.";
        }

        default String noIdPropertyFound(Object arg0, Locale... locale) {
            return MessageFormat.format("No field is annotated with @Id on {0} but it is required", arg0);
        }

        default String noInnerClasses(Object arg0, Locale... locale) {
            return MessageFormat.format("Inner classes can not be used.  Please make this type static:  {0}", arg0);
        }

        default String noMappedCollection(Object arg0, Locale... locale) {
            return MessageFormat.format("No collection has been mapped for {0}.  Types must be annotated with @Entity to be mapped to a collection.", arg0);
        }

        default String noSuitableConstructor(Object arg0, Locale... locale) {
            return MessageFormat.format("No suitable constructor found for type: ''{0}''", arg0);
        }

        default String noargConstructorNotFound(Object arg0, Locale... locale) {
            return MessageFormat.format("{0} does not have a 0 argument constructor.", arg0);
        }

        default String notArrayEnd(Locale... locale) {
            return "Call to end array made before the end of the array";
        }

        default String notAvailableInLegacy(Locale... locale) {
            return "This operation is not available to the legacy query implementation. Set the query factory to DefaultQueryFactor or don't use legacy() when building your MapperOptions.";
        }

        default String notDocumentEnd(Locale... locale) {
            return "Call to end document made before the end of the document";
        }

        default String notDocumentType(Locale... locale) {
            return "Value is not a document type";
        }

        default String notInValidState(Object arg0, Object arg1, Locale... locale) {
            return MessageFormat.format("Was not expecting a {0} while in the {1} state.", arg0, arg1);
        }

        default String notMappable(Object arg0, Locale... locale) {
            return MessageFormat.format("{0} is not a mappable type. Mappable types need to be annotated with either @Entity or @Embedded.", arg0);
        }

        default String notNull(Object arg0, Locale... locale) {
            return MessageFormat.format("{0} can not be null.", arg0);
        }

        default String notTopLevelType(Locale... locale) {
            return "Collection oriented operations can only be performed on \"top level\" types.  That is, types with a mapped @Id property.";
        }

        default String nullUpdateEntity(Locale... locale) {
            return "The value passed in for $set can not be null.";
        }

        default String onlyNumberTypesAllowed(Locale... locale) {
            return "Currently only the following types are allowed: integer, long, double, float.";
        }

        default String persistenceNotIntended(Locale... locale) {
            return "This type is not intended for persistence and is unsupported in this context.";
        }

        default String queryNotLogged(Locale... locale) {
            return "No query structure was logged for this query.";
        }

        default String referredTypeMissingId(Object arg0, Object arg1, Locale... locale) {
            return MessageFormat.format("{0} is annotated with @Reference but the class {1} is missing the @Id annotation", arg0, arg1);
        }

        default String translationNotCurrentlySupported(Locale... locale) {
            return "This mapping is not currently supported.";
        }

        default String unbalancedOpens(Object arg0, Object arg1, Object arg2, Locale... locale) {
            return MessageFormat.format("Starts and ends are currently unbalanced: arrays open:  {0},  documents open:  {1}.  current state:  {2}", arg0, arg1, arg2);
        }

        default String unhandledTypeData(Object arg0, Locale... locale) {
            return MessageFormat.format("Unknown type data:  {0}", arg0);
        }

        default String unmappedType(Object arg0, Locale... locale) {
            return MessageFormat.format("Unknown type: {0}", arg0);
        }

        default String unnamedConstructorParameter(Object arg0, Locale... locale) {
            return MessageFormat.format("Unnamed constructor parameter found on ''{0}''.  Annotate parameters with @Name.", arg0);
        }

        default String updateSortOptions(Object arg0, Object arg1, Locale... locale) {
            return MessageFormat.format("{0} can not be set if {1} already is", arg0, arg1);
        }

        default String valueCannotBeNull(Locale... locale) {
            return "Value can not be null.";
        }

        default String valuesCannotBeNullOrEmpty(Locale... locale) {
            return "Values can not be null or empty.";
        }

        default String versionManuallySet(Locale... locale) {
            return "When versioning entities, the version properties must not be manually given values.";
        }

        default String versionedUpdateOnNonversionedEntity(Locale... locale) {
            return "A versioned updated was attempted on a nonversioned entity.";
        }
    }

    /* loaded from: grasscutter.jar:dev/morphia/sofia/Sofia$LocalizedImpl.class */
    private static class LocalizedImpl implements Localized {
        private LocalizedImpl() {
        }
    }
}
