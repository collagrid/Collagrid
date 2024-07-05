import { defineCollection } from 'astro:content';
// @ts-ignore
import { docsSchema } from '@astrojs/starlight/schema';

export const collections = {
	docs: defineCollection({ schema: docsSchema() }),
};
